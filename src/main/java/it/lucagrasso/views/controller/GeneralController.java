package it.lucagrasso.views.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public abstract class GeneralController {

    protected static final String FXML_PATH = "/views/fxml/";
    protected static final String FXML_FILE_EXTENSION = ".fxml";
    protected String fxmlPath;

    public GeneralController(){
    }

    protected Parent createPage(String fxmlName) throws IOException {
        this.fxmlPath = FXML_PATH + fxmlName + FXML_FILE_EXTENSION;
        return FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
    }

    protected void switchScene(Stage stage, String fxmlName_for_NewScene) throws IOException {
        String fxmlSwitchScene = FXML_PATH + fxmlName_for_NewScene + FXML_FILE_EXTENSION;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlSwitchScene)));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}


