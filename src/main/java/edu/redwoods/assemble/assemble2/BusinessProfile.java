package edu.redwoods.assemble.assemble2;

import java.util.List;

public class BusinessProfile {
    private int profileId;
    private String name;
    private String openingTimes;
    private String location;
    private List<String> gamesAvailable;
    static int test;


    public void updateProfile(String name, String openingTimes, String location, List<String> gamesAvailable) {
        this.name = name;
        this.openingTimes = openingTimes;
        this.location = location;
        this.gamesAvailable = gamesAvailable;
    }

    public String getProfileDetails() {
        return "Profile ID: " + profileId + "\n" +
                "Name: " + name + "\n" +
                "Opening Times: " + openingTimes + "\n" +
                "Location: " + location + "\n" +
                "Games Available: " + String.join(", ", gamesAvailable);
    }

    public static void main(String[] args) {
        BusinessProfile business = new BusinessProfile();
        business.name = "Dungeons and Eureka";
        System.out.println("hello world");
        System.out.println("This is just a business name: " + business.name);

        // Example usage of the new methods
        business.updateProfile("New Business Name", "9 AM - 5 PM", "123 Main St", List.of("Game1", "Game2"));
        System.out.println(business.getProfileDetails());
    }
}
