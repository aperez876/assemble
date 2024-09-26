package edu.redwoods.assemble.assemble2;

public class BusinessTest {
    public static void main(String[] args) {
        // Create a new Business instance
        Business myBusiness = new Business();

        // Test createProfile method
        myBusiness.createProfile("Good Business", "The Best Business in the west!", "9 to 5");
        //myBusiness.createProfile("Tech Your Mom", "IT services and consulting", "9 AM - 5 PM");
        System.out.println("Profile created: " + myBusiness);

        // Test editProfile method
        //myBusiness.editProfile("Tech Your Mom Inc.", "IT services, consulting, and training", "9 AM - 6 PM");
        //System.out.println("Profile edited: " + myBusiness);

        // Test createMeetup method
        //myBusiness.createMeetup("Tech Meetup", "Discussing the latest in tech", "2024-09-25", "10:00:00", "Tech Park");
        //System.out.println("Meetup created: " + myBusiness);

        // Test deleteProfile method
        //myBusiness.deleteProfile();
        //System.out.println("Profile deleted: " + myBusiness);

        //This will write to the MySQL Server.
        BusinessDAO businessDAO = new BusinessDAO();
        businessDAO.saveBusiness(myBusiness);
        System.out.println("---------------------------------------------------------------------------------");

        //Reading from the MySQL Server
        businessDAO.readBusinesses();

        //Deleting business from MySQL Server
        //businessDAO.deleteBusiness(myBusiness.getBusinessId());
        businessDAO.deleteBusiness(1727324329);
        businessDAO.deleteBusiness(101);
        businessDAO.deleteBusiness(1);

        //Checking to see that the business got removed
        businessDAO.readBusinesses();

        System.out.println("Test IDFactory " + IDFactory.generateID());
    }
}
