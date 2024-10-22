package edu.redwoods.assemble.assemble2;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;



public class Business {
    private long businessId;
    private String name;
    private String description;
    private String openingTimes;
    private String location;
    private BusinessProfile profile;

    //Attributes for BusinessProfile
    private List<String> gamesAvailable;
    private String URL;
    private String imageURL;

    // Attributes for Meetup
    private long meetupId;
    private String meetupTitle;
    private String meetupDescription;
    private Date meetupDate;
    private Time meetupTime;
    private String meetupLocation;

    //The constructor initializes a new Business object and assigns a unique businessId using IDFactory.generateID().
    public Business() {
        this.businessId = IDFactory.generateID();
        this.profile = new BusinessProfile();
        this.meetupId = IDFactory.generateID();
    }

    public void createProfile(String name, String description, String openingTimes, String location, List<String> gamesAvailable, String URL, String imageURL) {
        // Implementation here
        this.name = name;
        this.description = description;
        this.openingTimes = openingTimes;
        this.location = location;
        this.URL = URL;
        this.imageURL = imageURL;
        this.gamesAvailable = gamesAvailable;
        profile.updateProfile(name, openingTimes, location, gamesAvailable, URL, imageURL);
    }

    public void setMeetupId(long meetupId) {
        this.meetupId = meetupId;
    }

    public void setMeetupTitle(String meetupTitle) {
        this.meetupTitle = meetupTitle;
    }

    public void setMeetupDescription(String meetupDescription) {
        this.meetupDescription = meetupDescription;
    }

    public void setMeetupDate(Date meetupDate) {
        this.meetupDate = meetupDate;
    }

    public void setMeetupTime(Time meetupTime) {
        this.meetupTime = meetupTime;
    }

    public void setMeetupLocation(String meetupLocation) {
        this.meetupLocation = meetupLocation;
    }


    // Method to create a meetup
    public void createMeetup(String title, String description, String date, String time, String location) {
        if (!time.matches("\\d{2}:\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Time must be in the format HH:MM:SS");
        }
        //setMeetupId(meetupId);
        this.meetupId = IDFactory.generateID();
        setMeetupTitle(title);
        setMeetupDescription(description);
        setMeetupDate(Date.valueOf(date));
        setMeetupTime(Time.valueOf(time));
        setMeetupLocation(location);
        System.out.println("Meetup created successfully!");
    }

     // Method to **CREATE A PROFILE**, probably to be implemented in another class:
     // maybe BusinessProfile.java(?)

    public void inputBusinessDetails(Scanner scanner) {

        System.out.print("Enter business name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter business Description: ");
        this.description = scanner.nextLine();
        System.out.print("Enter Hours or operation: ");
        this.openingTimes = scanner.nextLine();
        System.out.print("Enter business location: ");
        this.location = scanner.nextLine();
        System.out.println("Let's change the profile information: ");
        profile.inputProfileDetails(scanner);
        //myProfile.inputProfileDetails(scanner);
        System.out.println("Business created successfully!");
    }

    public void inputMeetupDetails(Scanner scanner) {

        System.out.print("Enter meetup title: ");
        this.meetupTitle = scanner.nextLine();
        System.out.print("Enter meetup description: ");
        this.meetupDescription = scanner.nextLine();
        //System.out.print("Enter meetup date: ");
        //TRYING TO USE THE DateTimeFactory
        this.meetupDate = DateTimeFactory.promptForDate(scanner);
        //this.meetupDate = scanner.nextLine();
        //System.out.print("Enter meetup time (HH:MM:SS): ");
        //USING DateTimeFactory
        this.meetupTime = DateTimeFactory.promptForTime(scanner);
        System.out.print("Enter meetup location: ");
        this.meetupLocation = scanner.nextLine();
        System.out.println("Meetup created successfully!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOpeningTimes(String openingTimes) {
        this.openingTimes = openingTimes;
    }

   public void setGamesAvailable(ArrayList gamesAvailable) {
        this.gamesAvailable = gamesAvailable;
   }

   public void setLocation(String location) {
        this.location = location;
   }

   public void setURL(String URL) {
        this.URL = URL;
   }

   public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
   }


    public void editProfile(String name, String description, String openingTimes) {
        if (name != null && !name.isEmpty()) {
            setName(name);
        }
        if (description != null && !description.isEmpty()) {
            setDescription(description);
        }
        if (openingTimes != null && !openingTimes.isEmpty()) {
            setOpeningTimes(openingTimes);
        }
        System.out.println("Profile updated successfully!");
    }

    public void deleteProfile() {
        this.businessId = 0;
        setName("");
        setDescription("");
        setOpeningTimes("");
        this.meetupId = 0;
        setMeetupTitle("");
        setMeetupDescription("");
        //setMeetupDate("");
        //setMeetupTime("");
        setMeetupLocation("");
        System.out.println("Profile deleted successfully!");
    }

    public void getProfile() {
        // Implementation here
    }

    public String getProfileDetails() {
        return profile.getProfileDetails();  // Use the profile's method to get details
    }

    public void createMeetup() {
        // Implementation here
    }

    public void notifyItemDrop() {
        // Implementation here
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", openingTimes='" + openingTimes + '\'' +
                ", location='" + location + '\'' +
                ", meetupId=" + meetupId +
                ", meetupTitle='" + meetupTitle + '\'' +
                ", meetupDescription='" + meetupDescription + '\'' +
                ", meetupDate='" + meetupDate + '\'' +
                ", meetupTime='" + meetupTime + '\'' +
                ", meetupLocation='" + meetupLocation + '\'' +
                '}';
    }

    // Getter methods
    public long getBusinessId() {
        return businessId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }

    public String getLocation() {
        return location;
    }

    public List getGamesAvailable() {
        return profile.getGamesAvailable();
    }

    public String getURL() {
        return profile.getURL();
    }

    public String getImageURL() {
        return profile.getImageURL();
    }

    public long getMeetupId() {
        return meetupId;
    }

    public String getMeetupTitle() {
        return meetupTitle;
    }

    public String getMeetupDescription() {
        return meetupDescription;
    }

    public Date getMeetupDate() {
        return meetupDate;
    }

    public Time getMeetupTime() {
        return meetupTime;
    }

    public String getMeetupLocation() {
        return meetupLocation;
    }
    //an example on how to use these methods

    public static void main(String[] args) {


        Business business = new Business();
        Scanner scanner = new Scanner(System.in);
        BusinessDAO dao = new BusinessDAO();

        business.inputBusinessDetails(scanner);
        System.out.println("Business Id: " + business.businessId);
        System.out.println("Business Name: " + business.getName());
        System.out.println("Business Description: " + business.getDescription());
        System.out.println("Opening Times: " + business.getOpeningTimes());
        System.out.println("Location: " + business.getLocation());


        scanner.close();
        /*
        business.createProfile(
                "Bookstore",
                "A place to find your favorite books",
                "9 AM - 9 PM");
        business.editProfile(
                "Updated Bookstore",
                "A place to find your favorite books and more",
                "9 AM - 10 PM");
        business.deleteProfile();
        business.createMeetup(
                "Java Programming Meetup",
                "A meetup for Java enthusiasts",
                "2024-09-25",
                "10:00:00",
                "Coffee Shop");
    }
        */
    }
}
