package edu.redwoods.assemble.assemble2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {
        // Database URL format: "jdbc:mysql://host:port/database_name"
        //String url = "jdbc:mysql://fdb1027.biz.nf:3306/4524081_user"; //doesn't work
        String url = "jdbc:mysql://mysql.biz.nf:3306/4524081_user"; //"connection refused"
        String user = "4524081_user";
        String password = "N(runJRX1FRd8DKa";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
