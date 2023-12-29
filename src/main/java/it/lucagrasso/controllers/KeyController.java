package it.lucagrasso.controllers;


import application.models.KeyModel;
import application.models.MazeModel;
import application.views.KeyView;

// import java.util.Timer;

/**
 * Created by Tingying He on 2020/10/18.
 */
public class KeyController {
    public KeyModel keyModel;
    public KeyView keyView;
    public int x, y;


    public KeyController() {
        keyModel = new KeyModel(this);
        keyView = new KeyView(this);
    }
    /**
     * @Auther: Luca Grasso
     * @Date: 2022/05/25
     * @LastModified: 2022/05/26
     */

    public void randomMove(){
        if(Math.random()<0.25){
            moveDown();
        }
        else if(Math.random()<0.5){
            moveLeft();
        }
        else if(Math.random()<0.75){
            moveRight();
        }else {
            moveUp();
        }

    }

    public void moveLeft() {
        if(x > 0 && MazeModel.map[x-1][y] == 1){
            keyView.setTranslateX(this.x * MazeModel.panelSize-25);
            x--;
        }
    }

    public void moveRight() {
        if(x < MazeModel.columns-1 && MazeModel.map[x+1][y] == 1){
            keyView.setTranslateX(this.x * MazeModel.panelSize+25);
            x++;
        }
    }

    public void moveUp() {
        if(y > 0 && MazeModel.map[x][y-1] == 1){
            keyView.setTranslateY(this.y * MazeModel.panelSize - 25);
            y--;
        }
    }

    public void moveDown() {
        if(y < MazeModel.rows-1 && MazeModel.map[x][y+1] == 1){
            keyView.setTranslateY(this.y * MazeModel.panelSize + 25);
            y++;
        }
    }
}

