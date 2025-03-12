package org.sdu.mikni23;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.sdu.mikni23.objects.EntityObject;
import org.sdu.mikni23.objects.GameDataObject;
import org.sdu.mikni23.objects.GameWorldObject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/*
 * The Core game engine
 */
public class App extends Application {

    private final GameDataObject gameData = new GameDataObject();
    private final GameWorldObject world = new GameWorldObject();
    private final Map<EntityObject, Polygon> polygons = new ConcurrentHashMap<>();
    private final Pane gameWindow = new Pane();

    public static void main(String[] args) {
        launch(App.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Set window title
        stage.setTitle("Asteroids");
        
        // set game window size
        gameWindow.setPrefSize(gameData.getDisplayWidth(), gameData.getDisplayHeight());


        

        // Create a scene with the gameWindow
        Scene scene = new Scene(gameWindow);

        // add the scene to the stage
        stage.setScene(scene);

        // Display the window
        stage.show();
    }
}