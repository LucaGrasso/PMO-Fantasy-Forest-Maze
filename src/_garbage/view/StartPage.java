package _garbage.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import application.models.CharacterModel;
import application.views.CharacterPage;
import application.views.GamePage;
import application.views.HelpPage;
import application.views.LevelPage;


/**
 * @author lgras  on  25/10/2022
 * @project fantasy-forest-maze
 */
public class StartPage extends Application {
    //    public int characterNum;
    // public String characterColor = "head1body1";
    public String filename;

    public static Scene gameScene;
    public static Set<KeyCode> pressedKeys = new HashSet<>();

    // Windows definition
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    public int pages = 0;


    // Start point for all JavaFx application is an abstract void also I need to Override
    @Override
    public void start(Stage primaryStage) {

        // Load the image paths from the models
        CharacterModel c = CharacterModel.getInstance();


        LaunchPage launchPage = new LaunchPage(WIDTH, HEIGHT, c);
        Scene launchScene = new Scene(launchPage, WIDTH, HEIGHT);
        launchScene.getStylesheets().add("application/views/fxml/style.css");

        CharacterPage characterPage = new CharacterPage(c);
        Scene chooseCharacterScene = new Scene(characterPage, WIDTH, HEIGHT);
        chooseCharacterScene.getStylesheets().add("application/views/fxml/style.css");

        LevelPage levelPage = new LevelPage(c);
        Scene levelScene = new Scene(levelPage, WIDTH, HEIGHT);
        levelScene.getStylesheets().add("application/views/fxml/style.css");


        HelpPage helpPage = new HelpPage();
        Scene helpScene = new Scene(helpPage, WIDTH, HEIGHT);
        helpScene.getStylesheets().add("application/views/fxml/style.css");

        launchPage.startBtn.setOnMouseClicked(mouseEvent -> primaryStage.setScene(chooseCharacterScene));
        launchPage.helpBtn.setOnMouseClicked(mouseEvent -> primaryStage.setScene(helpScene));

        characterPage.selectBtn.setOnMouseClicked(mouseEvent -> {
            pages = 2;
            levelPage.init(c);
            primaryStage.setScene(levelScene);

        });
        characterPage.backBtn.setOnMouseClicked(mouseEvent -> {
            pages = 1;
            primaryStage.setScene(launchScene);
        });

        levelPage.backBtn.setOnMouseClicked(mouseEvent -> primaryStage.setScene(chooseCharacterScene));
        levelPage.easyBtn.setOnMouseClicked(mouseEvent -> {
            GamePage gamePage = new GamePage(filename, c.getCurrent_Combination_Character());
            Pane root = new Pane();
            root.getChildren().add(gamePage);
            gameScene = new Scene(root, 800, 600);
            gameScene.setOnKeyPressed(e -> pressedKeys.add(e.getCode()));
            gameScene.setOnKeyReleased(e -> pressedKeys.remove(e.getCode()));


            filename = "Level 0";
            gamePage.init(filename, c.getCurrent_Combination_Character());
            primaryStage.setScene(helpScene);
            gamePage.mazeController.mazeView.helpBtn.setOnMouseClicked(mouseEvent1 -> primaryStage.setScene(helpScene));
        });
        levelPage.hardBtn.setOnMouseClicked(mouseEvent -> {
            GamePage gamePage = new GamePage(filename, c.getCurrent_Combination_Character());
            Pane root = new Pane();
            root.getChildren().add(gamePage);
            gameScene = new Scene(root, 800, 600);
            gameScene.setOnKeyPressed(e -> pressedKeys.add(e.getCode()));
            gameScene.setOnKeyReleased(e -> pressedKeys.remove(e.getCode()));


            filename = "Level 1";
            gamePage.init(filename, c.getCurrent_Combination_Character());
            primaryStage.setScene(helpScene);
            gamePage.mazeController.mazeView.helpBtn.setOnMouseClicked(mouseEvent12 -> primaryStage.setScene(helpScene));
        });

        helpPage.backBtn.setOnMouseClicked(mouseEvent -> {
            if (pages == 1) {
                primaryStage.setScene(launchScene);
            } else {
                primaryStage.setScene(gameScene);
                pages = 5;
            }

        });


//      launchScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Enchanted Woods");
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/img/tree1.png"))));
        pages = 1;
        primaryStage.setScene(launchScene);
        primaryStage.setResizable(false);
        primaryStage.show();

        //stop application on window close
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });

    }
}
