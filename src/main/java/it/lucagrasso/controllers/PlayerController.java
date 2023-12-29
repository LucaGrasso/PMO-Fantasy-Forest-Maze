package it.lucagrasso.controllers;

import application.models.PlayerModel;
import application.views.PlayerView;

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

