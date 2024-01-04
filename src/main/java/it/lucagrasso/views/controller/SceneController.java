package it.lucagrasso.views.controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController implements SceneChanger {
    private final Stage primaryStage;
    private final int width;
    private final int height;

    public SceneController(Stage stage, int width, int height) {
        this.primaryStage = stage;
        this.width = width;
        this.height = height;
    }

    @Override
    public void switchScene(String fxmlName) {
        try {
            String resource = "/views/fxml/" + fxmlName + ".fxml";
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(resource)));

            primaryStage.setTitle("Enchanted Woods");
            primaryStage.setScene(new Scene(root, width, height));
            primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/img/tree1.png"))));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            // handle error
        }
    }
}


























//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.Objects;
//
///**
// * @author: Luca Grasso
// * {@code @Project:} interactive-maze
// * @Date: 31/10/23
// */
//public class SceneController {
//    private final String nameScene;
//    private final Stage primaryStage;
//    private final int width;
//    private final int height;
//
//    public SceneController(String nameScene, Stage stage, int width, int height) {
//
//        this.nameScene = "/views/fxml/" + nameScene + ".fxml";
//        this.primaryStage = stage;
//        this.width = width;
//        this.height = height;
//        switchToCreation();
//    }
//
//    //
//    private void switchToCreation() {
//        try {
//            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(nameScene)));
//
//            primaryStage.setTitle("Enchanted Woods");
//            primaryStage.setScene(new Scene(root, width, height));
//            primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/img/tree1.png"))));
//            primaryStage.setResizable(false);
//            primaryStage.show();
//        }catch (Exception e){
//            // potentially add error logging here
//            // navigate to an error scene or display an error dialog
//            // return some value to signal the error
//        }
//    }
//
//    public void switchToScene(String nameScene, Stage stage, int width, int height) throws IOException {
//
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/application/views/fxml/" + nameScene + ".fxml")));
//
//        Scene scene = new Scene(root, width, height);
//        stage.setScene(scene);
//        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/img/tree1.png"))));
//        stage.setResizable(false);
//        stage.show();
//    }
//
//
//
//
//
//
//
//    public void switchToScene(String nameScene, Stage stage) throws IOException {
//
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/application/views/fxml/" + nameScene + ".fxml")));
//
//        Scene scene = new Scene(root, 800,600);
//        stage.setScene(scene);
//        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/img/tree1.png"))));
//        stage.setResizable(false);
//        stage.show();
//    }
//
//}
