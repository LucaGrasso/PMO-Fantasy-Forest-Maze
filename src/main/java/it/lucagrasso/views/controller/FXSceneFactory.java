package it.lucagrasso.views.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class FXSceneFactory implements SceneFactory {

    @Override
    public Scene createScene(String fxmlFilePath, int width, int height) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFilePath));
            return new Scene(root, width, height);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load FXML file: " + fxmlFilePath, e);
        }
    }
}
