package org.sdu.mikni23.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ModuleConfig.class);

        Game game = context.getBean(Game.class);
        game.start(primaryStage);

        context.close();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }

}
