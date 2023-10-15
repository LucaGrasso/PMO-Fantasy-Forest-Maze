package view.old;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import model.CharacterModel;

/**
 * @Auther: Luca Grasso
 * @Date: 2022/05/25
 * @LastModified: 2022/06/03
 */
public class LaunchPage extends BorderPane {
    public Button startBtn;
    public Button helpBtn;

    public LaunchPage(int width, int height, CharacterModel c) {
        HBox centralPane = new HBox();
        HBox topPane = new HBox();
//     VBox leftPane = new VBox();
        HBox bottomPane = new HBox();
//     VBox rightPane = new VBox();

//     this.setTop(topPane);
//     this.setRight(rightPane);
//     this.setLeft(leftPane);

        this.getStylesheets().add("view/fxml/02_LaunchPage.css");
        this.setBottom(bottomPane);
        this.setCenter(centralPane);
        this.setTop(topPane);


        Text text = new Text("Fantasy Forest");
        text.setFont(Font.font("AppleMyungjo", FontWeight.BOLD, 70));
        text.setFill(Color.KHAKI);
        topPane.setAlignment(Pos.BASELINE_CENTER);
        topPane.getChildren().add(text);


        startBtn = new Button("START");
        startBtn.setId("start-button");

        helpBtn = new Button("HELP");

        centralPane.setAlignment(Pos.BOTTOM_CENTER);
        centralPane.setSpacing(20);
        centralPane.getChildren().addAll(startBtn, helpBtn);


        //Botton Pane
        //CharacterModel c = new CharacterModel();

        ImageView imgView1 = new ImageView(c.getRandomImage_Character());
        imgView1.setFitWidth(240);
        imgView1.setFitHeight(240);
        //bottomPane.setSpacing(100);
        bottomPane.setAlignment(Pos.CENTER);

        ImageView imgView2 = new ImageView(c.getRandomImage_Character());
        imgView2.setFitWidth(100);
        imgView2.setFitHeight(100);

        ImageView imgView3 = new ImageView(c.getRandomImage_Character());
        imgView3.setFitWidth(140);
        imgView3.setFitHeight(140);

        ImageView imgView4 = new ImageView(c.getRandomImage_Character());
        imgView4.setFitWidth(200);
        imgView4.setFitHeight(200);

        bottomPane.getChildren().add(imgView2);
        bottomPane.getChildren().add(imgView3);
        bottomPane.getChildren().add(imgView4);
        bottomPane.getChildren().add(imgView1);

        //character animation imgView1
        TranslateTransition tt1 = new TranslateTransition(Duration.millis(4500), imgView1);
        tt1.setToX(0);
        tt1.setToY(200);
        tt1.setAutoReverse(true);
        tt1.setCycleCount(Timeline.INDEFINITE);
        tt1.play();

        //character animation imgView2
        TranslateTransition tt2 = new TranslateTransition(Duration.millis(9000), imgView2);
        tt2.setToX(600);
        tt2.setToY(0);
        tt2.setAutoReverse(true);
        tt2.setCycleCount(Timeline.INDEFINITE);
        tt2.play();

        //character animation imgView3
        TranslateTransition tt3 = new TranslateTransition(Duration.millis(1500), imgView3);
        tt3.setToX(0);
        tt3.setToY(+0);
        tt3.setAutoReverse(true);
        tt3.setCycleCount(Timeline.INDEFINITE);
        tt3.play();

        //character animation imgView4
        TranslateTransition tt4 = new TranslateTransition(Duration.millis(1000), imgView4);
        tt4.setToX(+20);
        tt4.setToY(0);
        tt4.setAutoReverse(true);
        tt4.setCycleCount(Timeline.INDEFINITE);
        tt4.play();

        TranslateTransition tt5 = new TranslateTransition(Duration.millis(8000), text);
        tt5.setToX(0);
        tt5.setToY(145);
        tt5.setAutoReverse(true);
        tt5.setCycleCount(1);
        tt5.play();

        TranslateTransition tt6 = new TranslateTransition(Duration.millis(7000), centralPane);
        tt6.setToX(0);
        tt6.setToY(-55);
        tt6.setAutoReverse(true);
        tt6.setCycleCount(1);
        tt6.play();


        this.setId("background-pane");

        //background image
//        BackgroundImage myBI = new BackgroundImage(new Image("resources.img/lauchpage2.png",width,height,false,true),
//                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//                BackgroundSize.DEFAULT);

        //this.setBackground(new Background(myBI));


    }

}