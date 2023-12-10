package application;


import javafx.application.Application;
import javafx.stage.Stage;
import view.controller.SceneController;
import utilities.ExceptionLogger;


// https://edencoding.com/mvc-in-javafx/

// Abstract of javafx.application.Application
// The entry point for JavaFX applications is the Application class:
// ref: https://openjfx.io/javadoc/11/javafx.graphics/javafx/application/Application.html
public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            new SceneController("01_Login", primaryStage, 800, 600);
        } catch (Exception e) {
            ExceptionLogger logger = ExceptionLogger.getInstance();

            logger.logException("Errore nell`apertura di 01_login", e);

        }
    }
}

