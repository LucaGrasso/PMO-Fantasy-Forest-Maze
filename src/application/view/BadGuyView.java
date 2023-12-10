package application.view;

import application.controller.BadGuyController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import application.model.MazeModel;

/**
 * @Auther: Luca Grasso
 * @Date: 2022/05/25
 * @LastModified: 2022/05/26
 */
public class BadGuyView extends StackPane {
    private ImageView badGuy;
    public BadGuyController badGuyController;

    public BadGuyView(BadGuyController badGuyController,int badguyNum){
        this.badGuyController = badGuyController;

        Image img = new Image("resource/img/badguy" + badguyNum + ".png");
        badGuy = new ImageView(img);
        badGuy.setFitWidth(MazeModel.panelSize);
        badGuy.setFitHeight(MazeModel.panelSize);
        this.getChildren().add(badGuy);
    }

}
