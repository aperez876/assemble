package edu.redwoods.assemble.assemble2;

import javax.xml.transform.Source;

public class BusinessTest {
    public static void main(String[] args) {
        // Create a new Business instance, and new DAO
        Business myBusiness = new Business();
        BusinessDAO businessDAO = new BusinessDAO();

        System.out.println("Database pre-read so we can see that is there before the database get updated");
        System.out.println("Preparing to read from the mySQL Database!");
        System.out.println("_________________________________________________________________________________");
        businessDAO.readBusinesses();
        System.out.println("========== END OF DATABASE ==============");

        // Test createProfile method
        //System.out.println("Testing create profile method.");
        //myBusiness.createProfile("Good Business", "The Best Business in the west!", "9 to 5");
        //myBusiness.createProfile("Tech Your Mom", "IT services and consulting", "9 AM - 5 PM");
        System.out.println("Profile created: " + myBusiness);

        // Test editProfile method
        System.out.println("Testing edit profile method");
        myBusiness.editProfile("Tech Your Mom Corp.", "IT services, consulting, and training", "CLOSED");
        System.out.println("Profile edited: " + myBusiness);

        // Test createMeetup method
        //System.out.println("Testing create meetup method");
        //myBusiness.createMeetup("Tech Meetup", "Discussing the latest in tech", "2024-09-25", "10:00:00", "Tech Park");
        //System.out.println("Meetup created: " + myBusiness);

        // Test deleteProfile method
        //myBusiness.deleteProfile();
        //System.out.println("Profile deleted: " + myBusiness);

        //This will write to the MySQL Server.

        System.out.println("Saving myBusiness to the mySQL Database!");
        businessDAO.saveBusiness(myBusiness);
        System.out.println("---------------------------------------------------------------------------------");

        //Reading from the MySQL Server
        System.out.println("Preparing to read from the mySQL Database!");
        System.out.println("_________________________________________________________________________________");
        businessDAO.readBusinesses();
        System.out.println("========== END OF DATABASE ==============");

        //Deleting business from MySQL Server
        //System.out.println("Preparing to delete a business from the mySQL Database!");
        //System.out.println("_________________________________________________________________________________");
        //businessDAO.deleteBusiness(myBusiness.getBusinessId());


        //Checking to see that the business got removed
        System.out.println("Preparing to reread from the mySQL Database!");
        System.out.println("_________________________________________________________________________________");
        businessDAO.readBusinesses();
        System.out.println("========== END OF DATABASE ==============");

        System.out.println("Preparing to generate IDFactory number!");
        System.out.println("_________________________________________________________________________________");
        System.out.println("Test IDFactory " + IDFactory.generateID());
    }
}
