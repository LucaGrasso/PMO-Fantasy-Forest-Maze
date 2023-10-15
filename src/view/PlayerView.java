package view;

import controller.PlayerController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import model.CharacterModel;
import model.MazeModel;



/**
 * @Auther: Luca Grasso
 * @Date: 2022/05/25
 * @LastModified: 2022/05/26
 */
public class PlayerView extends StackPane {
    public PlayerController playerController;

    public int x, y;
    private ImageView player;

    public PlayerView(PlayerController playerController){
        this.playerController = playerController;
        init(playerController.characterColor);
    }
    public void init(String characterColor){
        player = putCharacter(MazeModel.panelSize,MazeModel.panelSize,characterColor);
        this.getChildren().addAll(player);
    }

    public void moveLeft() {
        if(x > 0 && MazeModel.map[x-1][y] == 1){
            this.setTranslateX(this.x * MazeModel.panelSize-25);
            x--;
        }
    }

    public void moveRight() {
        if(x < MazeModel.columns-1 && MazeModel.map[x+1][y] == 1){
            this.setTranslateX(this.x * MazeModel.panelSize+25);
            x++;
        }
    }

    public void moveUp() {
        if(y > 0 && MazeModel.map[x][y-1] == 1){
            this.setTranslateY(this.y * MazeModel.panelSize - 25);
            y--;
        }
    }

    public void moveDown() {
        if(y < MazeModel.rows-1 && MazeModel.map[x][y+1] == 1){
            this.setTranslateY(this.y * MazeModel.panelSize + 25);
            y++;
        }
    }

    public ImageView putCharacter(int w, int h, String characterColor ){
        Image img = new Image(CharacterModel.getInstance().getURL_Character_Selected());
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(w);
        imgView.setFitHeight(h);

        return imgView;
    }


}
