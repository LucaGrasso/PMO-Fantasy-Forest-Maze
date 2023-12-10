package application.model.dao;

/*
 * @author Luca Grasso  on  25/10/2022
 * @project fantasy-forest-maze
 */


/* Singleton with no thread save */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSingleton {
    private static DatabaseConnectionSingleton instance;
    private Connection conn;
    private boolean isOlineDB;

    // sigleton constructor for database connection with handling of various exceptions
    private DatabaseConnectionSingleton() {
        try {

            /* Before Java 6 it was necessary to load the JDBC driver before using it.
               After Java 6 this should no more be necessary though */
            // Inseriti qua, perchè sono nativi del oggetto Connessione
            String driverClassName = "com.mysql.cj.jdbc.Driver";
            String password = "qwe123QWE@@@";
            String userName = "fantasyApplication";
            String url = "jdbc:mysql://212.227.30.95:3308/fantasyDB";

            Class.forName(driverClassName);
            /* open database connection */
            DriverManager.setLoginTimeout(1);
            this.conn = DriverManager.getConnection(url, userName, password);
            this.isOlineDB = true;
            System.out.println("Creata la connessione a " + url + userName + password);

            //  Error on creation
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
            this.isOlineDB = false;
            // Error specification on sql
        } catch (SQLException ex) {
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ex.printStackTrace();
            this.isOlineDB = false;
        }
    }


    // Connection is a property

    public static DatabaseConnectionSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnectionSingleton();
            System.out.println("creata la connessione");

        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnectionSingleton();
            System.out.println("creo una nuova Connessione essendo chiusa");
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    public boolean getDbOnline() {
        return isOlineDB;
    }
}


//
//    public Connection getConnection() throws SQLException {
//
//        Connection conn = null;
//        Properties connectionProps = new Properties();
//        connectionProps.put("user", this.userName);
//        connectionProps.put("password", this.password);
//
//        if (this.dbms.equals("mysql")) {
//            conn = DriverManager.getConnection(
//                    "jdbc:" + this.dbms + "://" +
//                            this.serverName +
//                            ":" + this.portNumber + "/",
//                    connectionProps);
//        } else if (this.dbms.equals("derby")) {
//            conn = DriverManager.getConnection(
//                    "jdbc:" + this.dbms + ":" +
//                            this.dbName +
//                            ";create=true",
//                    connectionProps);
//        }
//        System.out.println("Connected to database");
//        return conn;
//    }