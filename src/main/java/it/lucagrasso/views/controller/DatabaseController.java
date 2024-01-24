package it.lucagrasso.views.controller;

public class DatabaseController implements DatabaseStatusObserver {
    @Override
    public void handleDatabaseStatusChanged(boolean isDatabaseOnline) {
        //qui va il tuo codice per gestire il cambiamento dello stato del database
    }
}
