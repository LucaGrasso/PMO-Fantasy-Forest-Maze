package application.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import application.models.User;


// DAO (Data Access Object)
//Il UserDAO.java si occupa della persistenza dei dati:
// è un oggetto che fornisce un'interfaccia per accedere ai dati
// di un'origine dati come un database o un file.

public class UserDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());
    private static final String DB_CONN_STRING = System.getenv("DB_CONN_STRING");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    // crea una connessione al database
    private Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_CONN_STRING, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Database connection failed", e);
        }
        return connection;
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM utenti WHERE username = ?";
        try (Connection connection = createConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getString("username"), rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to find user by username", e);
        }
        return null;
    }

    public boolean save(User user) {
        String sql = "INSERT INTO utenti VALUES (?, ?)";
        try (Connection connection = createConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword()); // Still dangerous, better to hash the password

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to save user", e);
        }
        return false;
    }
}
