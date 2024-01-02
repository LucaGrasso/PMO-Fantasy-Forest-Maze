package it.lucagrasso.views.controller;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import it.lucagrasso.models.CharacterModel;

/**
 * @author: Luca Grasso
 * @Project: 02_LaunchPage.css
 * @Date: 31/10/22
 */
public class LaunchPageController extends BorderPane {


    @FXML private Text text;
    @FXML private HBox bottonPane;
    @FXML private ImageView imgView1;
    @FXML private ImageView imgView2;
    @FXML private ImageView imgView3;
    @FXML private ImageView imgView4;

    @FXML private HBox centralPane;
    @FXML private HBox topPane;

    @FXML private Button startBtn;
    @FXML private Button helpBtn;
    @FXML private Button topTenBtn;


    @FXML
    private void initialize() {
        text = new Text("Fantasy Forest");
        text.setFont(Font.font("AppleMyungjo", FontWeight.BOLD, 70));
        text.setFill(Color.KHAKI);
        topPane.setAlignment(Pos.BASELINE_CENTER);

        topPane.getChildren().add(text);

        // Load the image paths from the models
        CharacterModel c = CharacterModel.getInstance();

        imgView1 = new ImageView(c.getRandomImage_Character());
        imgView1.setFitWidth(240);
        imgView1.setFitHeight(240);

        imgView2 = new ImageView(c.getRandomImage_Character());
        imgView2.setFitWidth(100);
        imgView2.setFitHeight(100);
        imgView3 = new ImageView(c.getRandomImage_Character());
        imgView3.setFitWidth(140);
        imgView3.setFitHeight(140);
        imgView4 = new ImageView(c.getRandomImage_Character());
        imgView4.setFitWidth(200);
        imgView4.setFitHeight(200);
        //bottonPane.setAlignment(Pos.CENTER);
        bottonPane.getChildren().addAll(imgView2,imgView3,imgView4,imgView1);

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

        startBtn.setOnAction(actionEvent -> {
            Stage stage;
            stage = (Stage) startBtn.getScene().getWindow();
            new SceneController("03_CharacterPage", stage, 800, 600);
        });
    }


    //TODO: aggiungere il nome del giocatore e il suo score


}
