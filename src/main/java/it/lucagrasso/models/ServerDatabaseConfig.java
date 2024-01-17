package it.lucagrasso.models;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerDatabaseConfig extends DatabaseConfig {

    private final Properties properties;

    public ServerDatabaseConfig() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("com.mysql.cj.jdbc.Driver")) {
            properties.load(input);
        } catch (IOException e) {
            // gestisci l'eccezione
        }
    }

    @Override
    public String getUrl() {
        return properties.getProperty(System.getenv("DB_URL"));
    }

    @Override
    public String getUser() {
        return properties.getProperty(System.getenv("DB_USER"));
    }

    @Override
    public String getPassword() {
        return properties.getProperty(System.getenv("DB_PASSWORD"));
    }
}
