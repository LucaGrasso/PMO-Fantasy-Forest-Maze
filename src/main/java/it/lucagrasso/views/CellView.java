package it.lucagrasso.views;

import it.lucagrasso.controllers.CellController;
import it.lucagrasso.models.MazeModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @Auther: Luca Grasso
 * @Date: 2022/05/25
 * @LastModified: 2022/05/26
 */
public class CellView extends Pane {
    //    private Pane cellContent = new Pane();
    CellController cellController;
    Image fenceImg;
    Rectangle rec = new Rectangle(25,25);
    public ImageView fenceImgView;
    public ImageView whiteImgView = new ImageView();
    public boolean isPath = false;

    public CellView(CellController cellController) {
        this.cellController = cellController;
        this.rec.setFill(Color.WHITE);
        init(cellController.type);
    }


    public void init(int type) {

        if (type == 0) {
            Image wallImg = new Image("resource/img/wall.png");
            ImageView wallImgView = new ImageView(wallImg);
            wallImgView.setFitWidth(MazeModel.panelSize);
            wallImgView.setFitHeight(MazeModel.panelSize);
            this.getChildren().add(wallImgView);

        } else if (type == 1) {
            Image whiteImg = new Image("resource/img/white.png");
            whiteImgView.setImage(whiteImg);
            whiteImgView.setFitWidth(MazeModel.panelSize);
            whiteImgView.setFitHeight(MazeModel.panelSize);
            this.getChildren().add(whiteImgView);

        } else if (type == 2) { //
            Image bushImg = new Image("resource/img/bush.png");
            ImageView bushImgView = new ImageView(bushImg);
            bushImgView.setFitWidth(MazeModel.panelSize);
            bushImgView.setFitHeight(MazeModel.panelSize);
            this.getChildren().add(bushImgView);

        } else {
            switch (type) {
                case 3:
                    fenceImg = new Image("resource/img/tree0.png");
                    fenceImgView = new ImageView(fenceImg);
                    fenceImgView.setFitWidth(MazeModel.panelSize);
                    fenceImgView.setFitHeight(MazeModel.panelSize);
                    this.getChildren().add(fenceImgView);
                    break;
                case 4:
                    fenceImg = new Image("resource/img/tree1.png");
                    fenceImgView = new ImageView(fenceImg);
                    fenceImgView.setFitWidth(MazeModel.panelSize);
                    fenceImgView.setFitHeight(MazeModel.panelSize);
                    this.getChildren().add(fenceImgView);
                    break;
                case 5:
                    fenceImg = new Image("resource/img/tree2.png");
                    fenceImgView = new ImageView(fenceImg);
                    fenceImgView.setFitWidth(MazeModel.panelSize);
                    fenceImgView.setFitHeight(MazeModel.panelSize);
                    this.getChildren().add(fenceImgView);
                    break;
            }
        }


    }
}
