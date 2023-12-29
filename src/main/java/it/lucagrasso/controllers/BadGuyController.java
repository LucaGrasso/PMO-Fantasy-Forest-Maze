package it.lucagrasso.controllers;

import application.models.BadGuyModel;
import application.models.MazeModel;
import application.views.BadGuyView;

/**
 * @Auther: Luca Grasso
 * @Date: 2022/05/25
 * @LastModified: 2022/05/26
 */
public class BadGuyController {
    public BadGuyModel badGuyModel;
    public BadGuyView badGuyView;
    public int x, y;
    public int badGuyNum;


    public BadGuyController(int badGuyNum) {
        this.badGuyNum = badGuyNum;
        badGuyModel = new BadGuyModel(this);
        badGuyView = new BadGuyView(this,badGuyNum);
    }

    /**
     * Make bad guy randomly move to four directions
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
        }
        else if(Math.random()<1){
            moveUp();
        }

    }

    public void moveLeft() {
        if(x > 0 && MazeModel.map[x-1][y] == 1){
            badGuyView.setTranslateX(this.x * MazeModel.panelSize-25);
            x--;
        }
    }

    public void moveRight() {
        if(x < MazeModel.columns-1 && MazeModel.map[x+1][y] == 1){
            badGuyView.setTranslateX(this.x * MazeModel.panelSize+25);
            x++;
        }
    }

    public void moveUp() {
        if(y > 0 && MazeModel.map[x][y-1] == 1){
            badGuyView.setTranslateY(this.y * MazeModel.panelSize - 25);
            y--;
        }
    }

    public void moveDown() {
        if(y < MazeModel.rows-1 && MazeModel.map[x][y+1] == 1){
            badGuyView.setTranslateY(this.y * MazeModel.panelSize + 25);
            y++;
        }
    }

}