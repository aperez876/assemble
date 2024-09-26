package edu.redwoods.assemble.assemble2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessDAO { // DAO stands for Data Access Object
    public final static String URL = MySQLURLUserAndPass.url;
    private final static String USER = MySQLURLUserAndPass.username;
    private final static String PASSWORD = MySQLURLUserAndPass.password;

    public void saveBusiness(Business business) {
        String checkSQL = "SELECT COUNT(*) FROM Business WHERE name = ?";
        String insertSQL = "INSERT INTO Business (businessId, name, description, openingTimes, meetupId, meetupTitle, meetupDescription, meetupDate, meetupTime, meetupLocation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String updateSQL = "UPDATE Business SET description = ?, openingTimes = ?, meetupId = ?, meetupTitle = ?, meetupDescription = ?, meetupDate = ?, meetupTime = ?, meetupLocation = ? WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement checkStmt = conn.prepareStatement(checkSQL);
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
             PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {

            checkStmt.setString(1, business.getName());
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    // If Business has the same name, update info
                    System.out.println("BusinessDAO says: Updating business: " + business.getName());
                    updateStmt.setString(1, business.getDescription());
                    updateStmt.setString(2, business.getOpeningTimes());
                    updateStmt.setLong(3, business.getMeetupId());
                    updateStmt.setString(4, business.getMeetupTitle());
                    updateStmt.setString(5, business.getMeetupDescription());
                    updateStmt.setDate(6, business.getMeetupDate() != null ? java.sql.Date.valueOf(business.getMeetupDate()) : null);
                    updateStmt.setTime(7, business.getMeetupTime() != null ? java.sql.Time.valueOf(business.getMeetupTime()) : null);
                    updateStmt.setString(8, business.getMeetupLocation());
                    updateStmt.setString(9, business.getName());
                    updateStmt.executeUpdate();
                    System.out.println("BusinessDAO says: Business information was updated!!!!");
                } else {
                    // If business does not exist, create it
                    System.out.println("BusinessDAO says: Inserting new business: " + business.getName());
                    insertStmt.setLong(1, business.getBusinessId());
                    insertStmt.setString(2, business.getName());
                    insertStmt.setString(3, business.getDescription());
                    insertStmt.setString(4, business.getOpeningTimes());
                    insertStmt.setLong(5, business.getMeetupId());
                    insertStmt.setString(6, business.getMeetupTitle());
                    insertStmt.setString(7, business.getMeetupDescription());
                    insertStmt.setDate(8, business.getMeetupDate() != null ? java.sql.Date.valueOf(business.getMeetupDate()) : null);
                    insertStmt.setTime(9, business.getMeetupTime() != null ? java.sql.Time.valueOf(business.getMeetupTime()) : null);
                    insertStmt.setString(10, business.getMeetupLocation());
                    insertStmt.executeUpdate();
                    System.out.println("BusinessDAO says: Business SQL information saved successfully!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        //Method to delete a business
        public void deleteBusiness ( long businessId){
            String deleteSQL = "DELETE FROM Business WHERE businessId = ?";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {

                deleteStmt.setLong(1, businessId);
                int rowsAffected = deleteStmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("BusinessDAO says: Business deleted!!!!");
                } else {
                    System.out.println("BusinessDAO says: No Business found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void readBusinesses () {
            String sql = "SELECT * FROM Business";

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    long businessId = rs.getInt("businessId");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String openingTimes = rs.getString("openingTimes");
                    long meetupId = rs.getInt("meetupId");
                    String meetupTitle = rs.getString("meetupTitle");
                    String meetupDescription = rs.getString("meetupDescription");
                    java.sql.Date meetupDate = rs.getDate("meetupDate");
                    java.sql.Time meetupTime = rs.getTime("meetupTime");
                    String meetupLocation = rs.getString("meetupLocation");

                    // Print or process the data as needed
                    System.out.println("BusinessDAO says: This data is retrieved from our MySQL Server!!");
                    System.out.println("Business ID: " + businessId);
                    System.out.println("Name: " + name);
                    System.out.println("Description: " + description);
                    System.out.println("Opening Times: " + openingTimes);
                    System.out.println("Meetup ID: " + meetupId);
                    System.out.println("Meetup Title: " + meetupTitle);
                    System.out.println("Meetup Description: " + meetupDescription);
                    System.out.println("Meetup Date: " + meetupDate);
                    System.out.println("Meetup Time: " + meetupTime);
                    System.out.println("Meetup Location: " + meetupLocation);
                    System.out.println("-------------------------------");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }