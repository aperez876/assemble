package edu.redwoods.assemble.assemble2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    /*
    This code can be used to establish a connection to a MySQL database.
    You would need to have the MySQLURLUserAndPass class properly defined with
    the database URL, username, and password. This is useful for applications that
    need to interact with a MySQL database, such as retrieving or storing data
    */

public class MySQLConnection {

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(MySQLURLUserAndPass.url,
                MySQLURLUserAndPass.username,
                MySQLURLUserAndPass.password)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


