package it.lucagrasso.views.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class LoginFormController {
    @FXML
    private Circle databaseStatusIndicator;



    // L'implementazione di DatabaseStatusObserver
    public final DatabaseStatusObserver databaseStatusObserver = new DatabaseStatusObserver() {
        @Override
        public void handleDatabaseStatusChanged(boolean isDatabaseOnline) {
            updateDatabaseStatusIndicator(isDatabaseOnline);
            System.out.print("Sono dentro al controller di merda");
        }
    };

    @FXML
    private void loginButtonAction(ActionEvent event){
        System.out.print("Ho premuto il pulsante");

    }

    // il metodo che aggiorna l'indicatore dello stato del database
    public void updateDatabaseStatusIndicator(boolean isOnline) {
        if (isOnline) {
            databaseStatusIndicator.setFill(Color.GREEN);
        } else {
            databaseStatusIndicator.setFill(Color.RED);
        }
    }
}
