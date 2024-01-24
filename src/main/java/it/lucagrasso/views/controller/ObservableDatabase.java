package it.lucagrasso.views.controller;

public interface ObservableDatabase {
    void addObserver(DatabaseStatusObserver observer);
    void removeObserver(DatabaseStatusObserver observer);
    void setStatus(boolean isDatabaseOnline);
}
