package edu.redwoods.assemble.assemble2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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


