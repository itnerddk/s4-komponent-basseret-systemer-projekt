package org.sdu.mikni23.main;

import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;
import org.sdu.mikni23.common.interfaces.PostEntityProcessingServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/*
 * The Core game engine
 */
public class Game {

    private final GameDataObject gameData = new GameDataObject();
    private final GameWorldObject world = new GameWorldObject();
    private final Map<EntityObject, Polygon> polygons = new ConcurrentHashMap<>();
    private final Pane gameWindow = new Pane();

    private ServiceLoader<GamePluginServiceInterface> gamePluginServices;
    private ServiceLoader<EntityProcessingServiceInterface> entityProcessingServices;
    private ServiceLoader<PostEntityProcessingServiceInterface> postEntityProcessingServices;

    public Game(
        ServiceLoader<GamePluginServiceInterface> gamePluginServices, 
        ServiceLoader<EntityProcessingServiceInterface> entityProcessingServices,
        ServiceLoader<PostEntityProcessingServiceInterface> postEntityProcessingServices
        ) {
        
        this.gamePluginServices = gamePluginServices;
        this.entityProcessingServices = entityProcessingServices;
        this.postEntityProcessingServices = postEntityProcessingServices;
    }

    public void start(Stage stage) throws Exception {
        // Set window title
        stage.setTitle("Asteroids");
        
        // set game window size
        gameWindow.setPrefSize(gameData.getDisplayWidth(), gameData.getDisplayHeight());

        // Create a scene with the gameWindow
        Scene scene = new Scene(gameWindow);

        // key pressed events
        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.LEFT) || event.getCode().equals(KeyCode.A)) {
                gameData.getKeys().setLeft(true);
            } else if (event.getCode().equals(KeyCode.RIGHT) || event.getCode().equals(KeyCode.D)) {
                gameData.getKeys().setRight(true);
            } else if (event.getCode().equals(KeyCode.UP) || event.getCode().equals(KeyCode.W)) {
                gameData.getKeys().setUp(true);
            } else if (event.getCode().equals(KeyCode.DOWN) || event.getCode().equals(KeyCode.S)) {
                gameData.getKeys().setDown(true);
            } else if (event.getCode().equals(KeyCode.SPACE)) {
                gameData.getKeys().setSpace(true);
            }
        });

        // key release events
        scene.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.LEFT) || event.getCode().equals(KeyCode.A)) {
                gameData.getKeys().setLeft(false);
            } else if (event.getCode().equals(KeyCode.RIGHT) || event.getCode().equals(KeyCode.D)) {
                gameData.getKeys().setRight(false);
            } else if (event.getCode().equals(KeyCode.UP) || event.getCode().equals(KeyCode.W)) {
                gameData.getKeys().setUp(false);
            } else if (event.getCode().equals(KeyCode.DOWN) || event.getCode().equals(KeyCode.S)) {
                gameData.getKeys().setDown(false);
            } else if (event.getCode().equals(KeyCode.SPACE)) {
                gameData.getKeys().setSpace(false);
            }
        });

        // load all plugins
        for (GamePluginServiceInterface plugin : getGamePluginServices()) {
            plugin.start(gameData, world);
        }

        // start rendering
        render();

        // add the scene to the stage
        stage.setScene(scene);

        // Display the window
        stage.show();
    }

    private void update() {
        for (EntityProcessingServiceInterface entityProcessorService : getEntityProcessingServices()) {
            entityProcessorService.process(gameData, world);
        }
        for (PostEntityProcessingServiceInterface postEntityProcessorService : getPostEntityProcessingServices()) {
            postEntityProcessorService.process(gameData, world);
        }
    }

    private void draw() {
        for (EntityObject polygonEntity : polygons.keySet()) {
            if (!world.getEntities().contains(polygonEntity)) {
                Polygon removedPolygon = polygons.get(polygonEntity);
                polygons.remove(polygonEntity);
                gameWindow.getChildren().remove(removedPolygon);
            }
        }

        for (EntityObject entity : world.getEntities()) {
            Polygon polygon = polygons.get(entity);
            if (polygon == null) {
                polygon = new Polygon(entity.getPolygonCoordinates());
                polygons.put(entity, polygon);
                gameWindow.getChildren().add(polygon);
            }
            polygon.setTranslateX(entity.getX());
            polygon.setTranslateY(entity.getY());
            polygon.setRotate(entity.getR());
        }
    }

    private void render() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                draw();
            }
        }.start();
    }
    

    // Service loaders
    private ServiceLoader<GamePluginServiceInterface> getGamePluginServices() {
        // Value now set by constructor
        //if (gamePluginServices == null) {
        //    gamePluginServices = ServiceLoader.load(GamePluginServiceInterface.class);
        //    System.out.println("Loaded the following GamePluginServices:");
        //    for (GamePluginServiceInterface plugin : gamePluginServices) {
        //        System.out.println(" - " + plugin.getClass().getSimpleName());
        //    } 
        //}
        return gamePluginServices;
    }

    private ServiceLoader<EntityProcessingServiceInterface> getEntityProcessingServices() {
        // Value now set by constructor
        //if (entityProcessingServices == null) {
        //    entityProcessingServices = ServiceLoader.load(EntityProcessingServiceInterface.class);
        //    System.out.println("Loaded the following EntityProcessingServices:");
        //    for (EntityProcessingServiceInterface plugin : entityProcessingServices) {
        //        System.out.println(" - " + plugin.getClass().getSimpleName());
        //    }
        //}
        return entityProcessingServices;
    }

    private ServiceLoader<PostEntityProcessingServiceInterface> getPostEntityProcessingServices() {
        // Value now set by constructor
        //if (postEntityProcessingServices == null) {
        //    postEntityProcessingServices = ServiceLoader.load(PostEntityProcessingServiceInterface.class);
        //    System.out.println("Loaded the following PostEntityProcessingServices:");
        //    for (PostEntityProcessingServiceInterface plugin : postEntityProcessingServices) {
        //        System.out.println(" - " + plugin.getClass().getSimpleName());
        //    }
        //}
        return postEntityProcessingServices;
    }
}