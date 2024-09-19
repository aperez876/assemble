package edu.redwoods.assemble.assemble2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusinessDAO { //DAO stands for Data Access Operator
    private static final String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_4524081_user"; //Seems to be working. Somtime need to import mySQL.jar
    private static final String USER = "freedb_4524081_user";
    private static final String PASSWORD = "MP94YF&?qcbywwN";

    public void saveBusiness(Business business) {
        String sql = "INSERT INTO Business (businessId, name, description, openingTimes, meetupId, meetupTitle, meetupDescription, meetupDate, meetupTime, meetupLocation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, business.getBusinessId());
            pstmt.setString(2, business.getName());
            pstmt.setString(3, business.getDescription());
            pstmt.setString(4, business.getOpeningTimes());
            pstmt.setInt(5, business.getMeetupId());
            pstmt.setString(6, business.getMeetupTitle());
            pstmt.setString(7, business.getMeetupDescription());
            pstmt.setDate(8, java.sql.Date.valueOf(business.getMeetupDate()));
            pstmt.setTime(9, java.sql.Time.valueOf(business.getMeetupTime()));
            pstmt.setString(10, business.getMeetupLocation());

            pstmt.executeUpdate();
            System.out.println("Business information saved successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
