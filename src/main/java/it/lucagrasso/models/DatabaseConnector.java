package it.lucagrasso.models;

import it.lucagrasso.views.controller.DatabaseStatusObserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnector implements Runnable {
    private final DatabaseConfig config;
    private DatabaseStatusObserver databaseStatusObserver;

    private static Logger logger = Logger.getLogger(DatabaseConnector.class.getName());

    public DatabaseConnector(DatabaseConfig config, DatabaseStatusObserver observer) {
        this.config = config;
        this.databaseStatusObserver = observer;
    }

    @Override
    public void run() {
        Connection connection = null;
        try {
            // Carica il driver MySQL JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Esegui la connessione al database qui con le informazioni provenienti da config
            String url = config.getUrl();
            String user = config.getUser();
            String password = config.getPassword();
            connection = DriverManager.getConnection(url, user, password);
            // Se la connessione ha esito positivo, notifica l'observer
            databaseStatusObserver.handleDatabaseStatusChanged(true);
        } catch(SQLException | ClassNotFoundException ex){
            // Gestisci le eccezioni di connessione al database o del driver
            logger.log(Level.SEVERE, "Database connection failed", ex);
            // Notifica l'observer che la connessione ha avuto esito negativo
            databaseStatusObserver.handleDatabaseStatusChanged(false);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    logger.log(Level.WARNING, "Failed to close connection", ex);
                }
            }
        }
    }
}
