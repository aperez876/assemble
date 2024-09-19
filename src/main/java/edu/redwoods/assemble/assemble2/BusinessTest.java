package edu.redwoods.assemble.assemble2;

public class BusinessTest {
    public static void main(String[] args) {
        // Create a new Business instance
        Business myBusiness = new Business();

        // Test createProfile method
        myBusiness.createProfile(1, "Tech Solutions", "IT services and consulting", "9 AM - 5 PM");
        System.out.println("Profile created: " + myBusiness);

        // Test editProfile method
        myBusiness.editProfile(1, "Tech Solutions Inc.", "IT services, consulting, and training", "9 AM - 6 PM");
        System.out.println("Profile edited: " + myBusiness);

        // Test createMeetup method
        myBusiness.createMeetup(101, "Tech Meetup", "Discussing the latest in tech", "2024-09-25", "10:00 AM", "Tech Park");
        System.out.println("Meetup created: " + myBusiness);

        // Test deleteProfile method
        myBusiness.deleteProfile();
        System.out.println("Profile deleted: " + myBusiness);
    }
}
