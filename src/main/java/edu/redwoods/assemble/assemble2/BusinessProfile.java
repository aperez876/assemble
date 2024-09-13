package edu.redwoods.assemble.assemble2;

import java.util.List;

public class BusinessProfile {
    private int profileId;
    private String name;
    private String openingTimes;
    private String location;
    private List<String> gamesAvailable;
    static int test;


    public void updateProfile() {
        // Implementation here
    }

    public void getProfileDetails() {
        // Implementation here
    }

    public static void main(String[] args) {
        BusinessProfile business = new BusinessProfile();
        business.name = "Business Name Here";
        System.out.println("hello world");
        System.out.println("This is just a business name: " + business.name);

    }
}
