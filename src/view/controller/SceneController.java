package view.controller;

import application.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author: Luca Grasso
 * @Project: interactive-maze
 * @Date: 31/10/22
 */
public class SceneController {
    private final String nameScene;
    private final Stage primaryStage;
    private final int widht;
    private final int height;


    public SceneController(String nameScene, Stage stage, int width, int height) {
        this.nameScene = "/view/fxml/" + nameScene + ".fxml";
        this.primaryStage = stage;
        this.widht = width;
        this.height = height;
        switchToCreation();
    }

    private void switchToCreation() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(nameScene)));

            primaryStage.setTitle("Enchanted Woods");
            primaryStage.setScene(new Scene(root, widht, height));
            primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/img/tree1.png"))));
            primaryStage.setResizable(false);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void switchToScene(String nameScene, Stage stage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/fxml/" + nameScene + ".fxml")));

        Scene scene = new Scene(root, 800,600);
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/img/tree1.png"))));
        stage.setResizable(false);
        stage.show();
    }

}
