package edu.redwoods.assemble.assemble2;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

    /*
    •	The BusinessProfile class is designed to represent a business with various attributes.
    •	It includes methods to update and retrieve profile details.
    •	The main method shows how to use the class and its methods.
    */

public class BusinessProfile {

    private long profileId;
    /*private String name;
    private String openingTimes;
    private String location;*/
    private List<String> gamesAvailable;
    private String URL;
    private String imageURL;

    //Constructor to generate a unique profileId
    public BusinessProfile() {
        this.profileId = IDFactory.generateID();
    }

    // Getter for profileId
    public long getProfileId() {
        return profileId;
    }

    // Getter for gamesAvailable
    public List<String> getGamesAvailable() {
        return gamesAvailable;
    }

    // Getter for URL
    public String getURL() {
        return URL;
    }

    // Getter for imageURL
    public String  getImageURL() {
        return imageURL;
    }

    public void inputProfileDetails(Scanner scanner) {

        System.out.println("Enter business games available: ");
        this.gamesAvailable = Collections.singletonList(scanner.nextLine());
        System.out.println("Enter business URL: ");
        this.URL = scanner.nextLine();
        System.out.println("Enter business imageURL: ");
        this.imageURL = scanner.nextLine();
        System.out.println("Profile created successfully!");
    }

    public void updateProfile(String name, String openingTimes, String location, List<String> gamesAvailable, String URL, String imageURL) {
        /*this.name = name;
        this.openingTimes = openingTimes;
        this.location = location;*/
        this.gamesAvailable = gamesAvailable;
        this.URL = URL;
        this.imageURL = imageURL;
    }

    public String getProfileDetails() {
        return "Profile ID: " + profileId + "\n" +
                /*"Name: " + name + "\n" +
                "Opening Times: " + openingTimes + "\n" +
                "Location: " + location + "\n" +*/
                "Games Available: " + String.join(", ", gamesAvailable) + "\n" +
                "Business Website: " + URL + "\n" +
                "Business Image: " + imageURL;
    }



    public static void main(String[] args) {
        //BusinessProfile business = new BusinessProfile();
        //business.name = "Dungeons and Eureka";
        //System.out.println("hello world");
        //System.out.println("This is just a business name: " + business.name);

        // Example usage of the new methods
        //business.updateProfile("New Business Name", "9 AM - 5 PM", "123 Main St", List.of("Game1", "Game2"),"www.google.com","https://i.pinimg.com/736x/79/5e/bb/795ebb5f4a470cd7242136237f61fc53.jpg");
        //System.out.println(business.getProfileDetails());
    }
}
