package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.PlayerModel;
import view.PlayerView;

import java.security.PublicKey;

/**
 * @Auther: Luca Grasso
 * @Date: 2022/05/25
 * @LastModified: 2022/05/26
 */
public class PlayerController {
    public String characterColor;
    public PlayerModel playerModel;
    public PlayerView playerView;

    public PlayerController(String characterColor){
        this.characterColor = characterColor;

        playerModel = new PlayerModel(this);
        playerView = new PlayerView(this);

    }

}

