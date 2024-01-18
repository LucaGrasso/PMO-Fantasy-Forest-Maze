package it.lucagrasso.models;

public class ServerDatabaseConfig extends DatabaseConfig {

    public ServerDatabaseConfig() {
        super.load("server-db.properties");
    }
}
