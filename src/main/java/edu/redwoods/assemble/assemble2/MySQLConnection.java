package edu.redwoods.assemble.assemble2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {
        // Database URL format: "jdbc:mysql://host:port/database_name"
        //String url = "jdbc:mysql://fdb1027.biz.nf:3306/4524081_user"; //doesn't work
        //String url = "jdbc:mysql://mysql.biz.nf:3306/4524081_user"; //"connection refused"
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_4524081_user"; //"connection refused"
        String user = "freedb_4524081_user";
        String password = "MP94YF&?qcbywwN";
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


