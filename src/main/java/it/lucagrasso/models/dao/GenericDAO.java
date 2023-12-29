package it.lucagrasso.models.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lgras  on  28/10/2023
 * @project fantasy-forest-maze
 */

public abstract class GenericDAO {

    //Protected
    protected final String tableName;
    protected Connection con;

    protected GenericDAO(String tableName) throws SQLException {
        this.tableName = tableName;
        this.con = DatabaseConnectionSingleton.getInstance().getConnection();
    }


}
