package edu.redwoods.assemble.assemble2;

import java.sql.*;

// DAO stands for Data Access Object

//    BusinessDAO that interacts with a database
//    to perform CRUD (Create, Read, Update, Delete) operations on Business objects

    /*
    •	saveBusiness: Checks if a business exists and updates or inserts accordingly.
    •	deleteBusiness: Deletes a business by its ID.
    •	readBusinesses: Retrieves and prints all business records.
    */


public class BusinessDAO {

    public final static String URL = MySQLURLUserAndPass.url;
    private final static String USER = MySQLURLUserAndPass.username;
    private final static String PASSWORD = MySQLURLUserAndPass.password;

    /*
    This method saves a Business object to the database. It first checks if
    a business with the same name exists. If it does, it updates the existing record;
    otherwise, it inserts a new record
    */
    public void saveBusiness(Business business) {
        String checkSQL = "SELECT COUNT(*) FROM Business WHERE name = ?";
        String insertSQL = "INSERT INTO Business (businessId, name, description, openingTimes, meetupId, meetupTitle, meetupDescription, meetupDate, meetupTime, meetupLocation, location, URL, imageURL, gamesAvailable) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String updateSQL = "UPDATE Business SET description = ?, openingTimes = ?, meetupId = ?, meetupTitle = ?, meetupDescription = ?, meetupDate = ?, meetupTime = ?, meetupLocation = ?, location = ?, URL = ?, imageURL = ?, gamesAvailable = ? WHERE name = ?";

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
                    updateStmt.setDate(6, business.getMeetupDate() != null ? java.sql.Date.valueOf(String.valueOf(business.getMeetupDate())) : null);
                    updateStmt.setTime(7, business.getMeetupTime() != null ? java.sql.Time.valueOf(String.valueOf(business.getMeetupTime())) : null);
                    updateStmt.setString(8, business.getMeetupLocation());
                    updateStmt.setString(9, business.getLocation());
                    updateStmt.setString(10, business.getURL());
                    updateStmt.setString(11, business.getImageURL());
                    updateStmt.setString(12, business.getGamesAvailable().toString());
                    updateStmt.setString(13, business.getName());
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
                    insertStmt.setDate(8, business.getMeetupDate());// != null ? java.sql.Date.valueOf(business.getMeetupDate()) : null);
                    insertStmt.setTime(9, business.getMeetupTime());// != null ? java.sql.Time.valueOf(business.getMeetupTime()) : null);
                    insertStmt.setString(10, business.getMeetupLocation());
                    insertStmt.setString(11, business.getLocation());
                    insertStmt.setString(12, business.getURL());
                    insertStmt.setString(13, business.getImageURL());
                    //insertStmt.setString(14, business.getGamesAvailable().toString());
                    if (business.getGamesAvailable() == null) {
                        insertStmt.setString(14, "");
                    } else {
                        insertStmt.setString(14, business.getGamesAvailable().toString());  // Ensure not null
                    }

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
                    String location = rs.getString("location");
                    long meetupId = rs.getInt("meetupId");
                    String meetupTitle = rs.getString("meetupTitle");
                    String meetupDescription = rs.getString("meetupDescription");
                    java.sql.Date meetupDate = rs.getDate("meetupDate");
                    java.sql.Time meetupTime = rs.getTime("meetupTime");
                    String meetupLocation = rs.getString("meetupLocation");
                    String URL = rs.getString("URL");
                    String imageURL = rs.getString("imageURL");
                    String gamesAvailable = rs.getString("gamesAvailable");


                    // Print or process the data as needed
                    System.out.println("BusinessDAO says: This data is retrieved from our MySQL Server!!");
                    System.out.println("Business ID: " + businessId);
                    System.out.println("Name: " + name);
                    System.out.println("Description: " + description);
                    System.out.println("Opening Times: " + openingTimes);
                    System.out.println("Location: " + location);
                    System.out.println("Meetup ID: " + meetupId);
                    System.out.println("Meetup Title: " + meetupTitle);
                    System.out.println("Meetup Description: " + meetupDescription);
                    System.out.println("Meetup Date: " + meetupDate);
                    System.out.println("Meetup Time: " + meetupTime);
                    System.out.println("Meetup Location: " + meetupLocation);
                    System.out.println("URL: " + URL);
                    System.out.println("imageURL: " + imageURL);
                    System.out.println("Games Available: " + gamesAvailable);
                    System.out.println("-------------------------------");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //This will be the new class' used to access the Database
/*    public void saveBusiness(Business business) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(business);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Business> getBusinesses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Business", Business.class).list();
        }
    }*/
    }


