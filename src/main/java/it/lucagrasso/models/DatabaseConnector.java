package it.lucagrasso.models;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;


import it.lucagrasso.views.controller.DatabaseStatusObserver;

// La classe DatabaseConnector non blocca il JavaFX Application Thread
public class DatabaseConnector implements Runnable {

    private final DatabaseConfig config;
    private DatabaseStatusObserver databaseStatusObserver;

    public DatabaseConnector(DatabaseConfig config, DatabaseStatusObserver observer) {
        this.config = config;
        this.databaseStatusObserver = observer;
    }

    @Override
    public void run() {
        try {
            // Carica il driver MySQL JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Esegui la connessione al database qui con le informazioni provenienti da config
            String url = config.getUrl();
            String user = config.getUser();
            String password = config.getPassword();

            Connection connection = DriverManager.getConnection(url, user, password);

            // Se la connessione ha esito positivo, notifica l'observer
            databaseStatusObserver.handleDatabaseStatusChanged(true);
        } catch (SQLException | ClassNotFoundException ex) {
            // In caso di errore nella connessione o nell'identificazione del driver, notifica l'observer
            databaseStatusObserver.handleDatabaseStatusChanged(false);
        }
    }
}
