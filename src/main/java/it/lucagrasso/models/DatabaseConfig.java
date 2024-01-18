package it.lucagrasso.models;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private final Properties properties;

    public DatabaseConfig() {
        properties = new Properties();
    }

    protected void load(String propertiesFilename) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFilename)) {
            properties.load(input);
        } catch (IOException e) {
            // handle the exception
        }
    }

    public String getUrl() {
        return properties.getProperty("DB_URL");
    }

    public String getUser() {
        return properties.getProperty("DB_USER");
    }

    public String getPassword() {
        return properties.getProperty("DB_PASSWORD");
    }
}
