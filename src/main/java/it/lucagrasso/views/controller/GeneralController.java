package it.lucagrasso.views.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class GeneralController {

    protected static final String FXML_PATH = "/views/fxml/";
    protected static final String FXML_EXTETION = ".fxml";

    public GeneralController(){


    }

    protected Parent createPage(String fxmlPath) throws IOException {
        return FXMLLoader.load(getClass().getResource(fxmlPath));
    }

    protected void switchScene(Stage stage, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}


