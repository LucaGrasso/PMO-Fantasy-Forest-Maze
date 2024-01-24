package it.lucagrasso.views.controller;

import java.util.ArrayList;
import java.util.List;

public class ConcreteObservableDatabase implements ObservableDatabase {
    private final List<DatabaseStatusObserver> observers = new ArrayList<>();
    private boolean isDatabaseOnline;

    @Override
    public void addObserver(DatabaseStatusObserver observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(DatabaseStatusObserver observer){
        observers.remove(observer);
    }

    @Override
    public void setStatus(boolean isDatabaseOnline){
        this.isDatabaseOnline = isDatabaseOnline;
        notifyAllObservers();
    }

    private void notifyAllObservers(){
        for (DatabaseStatusObserver observer : observers) {
            observer.handleDatabaseStatusChanged(isDatabaseOnline);
        }
    }
}
