package edu.redwoods.assemble.assemble2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {

        MySQLURLUserAndPass mySQLDetails = new MySQLURLUserAndPass();

        try (Connection conn = DriverManager.getConnection(mySQLDetails.getUrl(),
                mySQLDetails.getUsername(),
                mySQLDetails.getPassword())) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


