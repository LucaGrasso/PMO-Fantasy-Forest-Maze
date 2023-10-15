package application;

//import com.sun.javafx.css.StyleManager;
//import com.sun.javafx.logging.PlatformLogger;
//import controller.MazeController;
//import model.MazeModel;

import javafx.application.Application;
import javafx.stage.Stage;
import view.controller.SceneController;


/**
 * @Auther: Luca Grasso
 * @Date: 2022/10/25
 */

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
        try{
            new SceneController("01_Login", primaryStage, 600, 400);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}