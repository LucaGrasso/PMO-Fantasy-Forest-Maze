package it.lucagrasso.views.controller;

/**
 * DatabaseStatusObserver is an interface that defines a method for handling database status changes.
 * Classes implementing this interface can be used to observe and react to changes in the database status.
 */

public interface DatabaseStatusObserver {
    void handleDatabaseStatusChanged(boolean isDatabaseOnline);
}
