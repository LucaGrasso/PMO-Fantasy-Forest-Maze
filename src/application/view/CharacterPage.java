package application.view;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import application.model.character.Character_ImageView_ID;
import application.model.CharacterModel;

/**
 * @Auther: Luca Grasso
 * @Date: 2022/05/25
 */

// BorderPane lays out children in top, left, right, bottom, and center positions.
public class CharacterPage extends BorderPane {


    private String headColor;
    private  String bodyColor;

    final HBox btnBox = new HBox();
    //head color pane
    final VBox headPane = new VBox();
    //body color pane
    final VBox bodyPane = new VBox();
    // CharacterSelection
    final VBox characterPane = new VBox();
    //Top Pane for Title
    final VBox topPane = new VBox();
    //button pane
    public Button selectBtn;
    public Button backBtn;
    private int currentCharacter = 1;
    final Button nextBtn;

    public CharacterPage(CharacterModel c) {
        this.getStylesheets().add("application/view/fxml/03_CharacterPage.css");
        this.setId("background-pane");

        this.setTop(topPane);
        this.setRight(headPane);
        this.setLeft(bodyPane);
        this.setBottom(btnBox);
        this.setCenter(characterPane);
        BorderPane.setMargin(topPane,  new Insets(-40, 10, 10, 10));
        BorderPane.setMargin(bodyPane, new Insets(-50, 10, 10, 10));
        BorderPane.setMargin(headPane, new Insets(-50, 10, 10, 10));

        putCharacter(c);

        // TopPane
        Text text = new Text("Create your Character");
        text.setY(-50);
        text.setFont(Font.font("Rockwell", FontWeight.BOLD, 40));
        text.setFill(Color.WHITESMOKE);

        Text text2 = new Text("Drag your color to character");
        text2.setFont(Font.font("Rockwell", FontWeight.BOLD, 20));
        text2.setFill(Color.GOLD);

        topPane.setAlignment(Pos.TOP_CENTER);
        topPane.setSpacing(40);
        topPane.getChildren().addAll(text,text2);

        //button style
        selectBtn = new Button("OK");
        backBtn =   new Button("BACK");
        nextBtn =   new Button("Character");

        btnBox.getChildren().addAll(backBtn, selectBtn, nextBtn);
        btnBox.setAlignment(Pos.CENTER);
        btnBox.setSpacing(20);

        // Instance of the imageView for the page
        ArrayList<Character_ImageView_ID> character_ImageView_Head = new ArrayList<>();
        ArrayList<Character_ImageView_ID> character_ImageView_Body = new ArrayList<>();

        // Iteration of image objects and its events
        Iterator<Image> characterImageI = c.getImage_Character().iterator();
        Iterator<String> nameImageI = c.getImageName().iterator();

        // Load the Image
        setCharacter_ImageView(character_ImageView_Head, characterImageI, nameImageI);
        setCharacter_ImageView(character_ImageView_Body, characterImageI, nameImageI);

        // Load HEAD pane
        character_ImageView_Head.forEach((e) -> {
            e.setFitHeight(100);
            e.setFitWidth(100);
            e.setOnDragDetected(mouseEvent -> {
                headColor = e.getNameId();
                c.setHeadNameID(e.getNameId());
                putCharacter(c);
            });
            headPane.getChildren().add(e);
        });
        headPane.setSpacing(30);
        headPane.setPadding(new Insets(20,0,0,0));

        //LOAD BODY pane
        character_ImageView_Body.forEach((e) -> {
            e.setFitHeight(100);
            e.setFitWidth(100);
            e.setOnDragDetected(mouseEvent -> {
                bodyColor = e.getNameId();
                c.setBodyNameID(e.getNameId());
                putCharacter(c);
            });
            bodyPane.getChildren().add(e);
        });
        bodyPane.setSpacing(30);
        bodyPane.setPadding(new Insets(20,0,0,0));

        // Setting the correct padding for OS System
        String os = System.getProperty("os.name").toLowerCase();

            // Mac or Linux System
        if (os.contains("mac") || os.contains("nix") || os.contains("aix") || os.contains("nux")) {
            System.out.println(os);
            this.setPadding(new Insets(80,100,40,100));
        } else {
            // Windows System
            System.out.println(os);
            this.setPadding(new Insets(60,100,40,100));
        }

        nextBtn.setOnMouseClicked(mouseEvent -> {
            // Cicle Option
            if (currentCharacter < c.getTotInt_Character()) {
                c.setCurrentCharacter( ++currentCharacter );
            } else {
                c.setCurrentCharacter( currentCharacter = 1 );
            }

            // Update the ImageView with new data
            Iterator<Image> characterImageIterator = c.getImage_Character().iterator();

            character_ImageView_Head.forEach(e -> e.setImage(characterImageIterator.next()));

            character_ImageView_Body.forEach(e -> e.setImage(characterImageIterator.next()));

            // Update Avatar
            putCharacter(c);
        });
    }

    private void setCharacter_ImageView(ArrayList<Character_ImageView_ID> a, Iterator<Image>  ImgI, Iterator<String> nameI){
        for(int i = 0; i < 3; i++) a.add(new Character_ImageView_ID(ImgI.next(), nameI.next()));
    }

    private void putCharacter(CharacterModel c){


        System.out.println(currentCharacter +"character" + headColor + bodyColor + ".png");

        ImageView imgView = new ImageView(c.getCurrentImage_Character());
        imgView.setFitHeight(240);
        imgView.setFitWidth(240);
        this.setCenter(imgView);

        TranslateTransition tt1 = new TranslateTransition(Duration.millis(5000), imgView);
        tt1.setToX(0);
        tt1.setToY(-50);
        tt1.setAutoReverse(true);
        tt1.setCycleCount(Timeline.INDEFINITE);
        tt1.play();

    }

}
