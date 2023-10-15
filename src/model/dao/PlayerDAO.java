package model.dao;

import java.sql.*;

/**
 * @author lgras  on  28/10/2022
 * @project fantasy-forest-maze
 */
public class PlayerDAO extends GenericDAO {


    //Private
    // Table
    private final static String TABLENAME = "userApplication";
    //Column
    private final static String USER_NAME = "user_name";
    private final static String USER_PASSWORD = "user_password";

    private final String nameField;
    private final String passwordField;

    //Constructor
    public PlayerDAO(String nameField, String passwordField) throws SQLException {
        super(TABLENAME);
        this.nameField = nameField;
        this.passwordField = passwordField;
    }

    public Boolean getIsPlayerUniquePresent() throws SQLException {

        String query = "SELECT " + USER_NAME + "," + USER_PASSWORD +
                       " FROM " + this.tableName +
                       " WHERE " + USER_NAME     + " = " + "'" + nameField        + "' AND "
                                 + USER_PASSWORD + " = " + "'" + passwordField    + "';";
        System.out.println(query);

        // prendo la connessione del padre e utilizzo per la query del mio metodo.
        PreparedStatement statement = con.prepareStatement(query);
        // attendo il risultato della query
        ResultSet res = statement.executeQuery(query);

        // Se il cursore è vuoto non ho nessun utente salvato
        if (!res.isBeforeFirst() ) {
            // console test command
            System.out.println("No data");
            return false;
        } else {
            // console test command
            System.out.println("data found");
            return true;
        }
    }

    public void setRegistrationPlayer(String sesso) throws SQLException {


        String query = "INSERT INTO " + this.tableName +
                " VALUES ( '" + nameField + "','" + passwordField + "','" + sesso + "'," + 0 + ");";
        System.out.println(query);
        try {
            // prendo la connessione del padre e utilizzo per la query del mio metodo.
            PreparedStatement statement = con.prepareStatement(query);

            // attendo il risultato della query
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example for Oracle

//    public static void viewTable(Connection con) throws SQLException {
//        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
//        try (Statement stmt = con.createStatement()) {
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                String coffeeName = rs.getString("COF_NAME");
//                int supplierID = rs.getInt("SUP_ID");
//                float price = rs.getFloat("PRICE");
//                int sales = rs.getInt("SALES");
//                int total = rs.getInt("TOTAL");
//                System.out.println(coffeeName + ", " + supplierID + ", " + price +
//                        ", " + sales + ", " + total);
//            }
//        } catch (SQLException e) {
//            JDBCTutorialUtilities.printSQLException(e);
//        }
//    }

