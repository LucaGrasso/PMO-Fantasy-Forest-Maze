package it.lucagrasso.models;

import application.controllers.PlayerController;

/**
 * @Auther: Luca Grasso
 * @Date: 2022/05/25
 * @LastModified: 2022/05/26
 */
public class PlayerModel {
    public PlayerController playerController;

    public PlayerModel(PlayerController playerController){
        this.playerController = playerController;

    }
}
