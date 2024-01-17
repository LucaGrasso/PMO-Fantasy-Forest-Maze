package it.lucagrasso;

import it.lucagrasso.models.DatabaseConfig;
import it.lucagrasso.models.DatabaseConnector;
import it.lucagrasso.models.ServerDatabaseConfig;
import it.lucagrasso.views.controller.DatabaseStatusObserver;
import it.lucagrasso.views.controller.LoginFormController;

import javafx.application.Application;
import javafx.stage.Stage;
import it.lucagrasso.views.controller.SceneController;
import it.lucagrasso.utilities.ExceptionLogger;


// https://edencoding.com/mvc-in-javafx/
// Abstract of javafx.application.Application
// The entry point for JavaFX applications is the Application class:
// ref: https://openjfx.io/javadoc/11/javafx.graphics/javafx/application/Application.html
public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Applicazione in inizializzazione");
        System.out.println("Test del main");
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {

            // Creo una connessione al Database in remoto
            DatabaseConfig config = new ServerDatabaseConfig();
            LoginFormController controller = new LoginFormController();
            DatabaseStatusObserver observer = controller.databaseStatusObserver;
            DatabaseConnector connector = new DatabaseConnector(config, observer);
            new Thread(connector).start();
            // --------------------------


            new SceneController("01_LoginNew", primaryStage, 800, 600);
        } catch (Exception e) {
            ExceptionLogger logger = ExceptionLogger.getInstance();
            logger.logException("Errore nell`apertura di 01_login", e);
        }
    }
}
