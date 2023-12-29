package it.lucagrasso.views;

import application.controllers.KeyController;
import application.models.MazeModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * @Auther: Luca Grasso
 * @Date: 2022/05/25
 * @LastModified: 2022/05/26
 */


public class KeyView extends StackPane {
    private ImageView key;
    public KeyController keyController;

    public KeyView(KeyController keyController){
        this.keyController = keyController;

        Image img = new Image("resource/img/key.png");
        key = new ImageView(img);
        key.setFitWidth(MazeModel.panelSize);
        key.setFitHeight(MazeModel.panelSize);
        this.getChildren().add(key);
    }
}
