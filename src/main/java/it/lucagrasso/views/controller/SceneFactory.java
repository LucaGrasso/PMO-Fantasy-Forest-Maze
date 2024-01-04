package it.lucagrasso.views.controller;

/**
 * Project PMO-Fantasy-Forest-Maze
 * Author  lgras  on  04/01/2024
 */

import javafx.scene.Scene;

public interface SceneFactory {
    Scene createScene(String fxmlFilePath, int width, int height);
}
