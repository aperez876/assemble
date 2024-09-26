package edu.redwoods.assemble.assemble2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLQuery {
    public static void main(String[] args) {
        String url = MySQLURLUserAndPass.url;
        String username = MySQLURLUserAndPass.username;
        String password = MySQLURLUserAndPass.password;

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Business WHERE businessid = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, 1); // Example ID value

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Business ID: " + rs.getInt("businessid"));
                System.out.println("Business: " + rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}