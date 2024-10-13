package edu.redwoods.assemble.assemble2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BusinessTest {
    public static void main(String[] args) {
        // Create a new Business instance, and new DAO
        Business myBusiness = new Business();
        //BusinessProfile myProfile = new BusinessProfile(); //we are editing my profile in the business class
        BusinessDAO businessDAO = new BusinessDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to read from the database? (Y/N) ");
        String answer1 = scanner.nextLine().trim().toUpperCase();
        if (answer1.equals("Y")) {
            System.out.println("Preparing to reread from the mySQL Database!");
            System.out.println("========= Start OF DATABASE =============");
            businessDAO.readBusinesses();
            System.out.println("========== END OF DATABASE ==============");
        } else {
            System.out.println("Moving on.");
        }

        /*//Testing BusinessProfile
        List<String> gamesAvailable = new ArrayList<>();
        gamesAvailable.add("Chess");
        gamesAvailable.add("D&D");*/




        //Test Business.inputBusinessDetails
        myBusiness.inputBusinessDetails(scanner);
        System.out.println("Want to schedule a meetup? (Y/N)");
        String answer = scanner.nextLine().trim().toUpperCase();

        if (answer.equals("Y")) {
            myBusiness.inputMeetupDetails(scanner);
        } else {
            System.out.println("Business Id: " + myBusiness.getBusinessId());
            System.out.println("Business Name: " + myBusiness.getName());
            System.out.println("Business Description: " + myBusiness.getDescription());
            System.out.println("Opening Times: " + myBusiness.getOpeningTimes());
            System.out.println("Location: " + myBusiness.getLocation());
            System.out.println(myBusiness.getProfileDetails());
        }




        // Test createProfile method
        //System.out.println("Testing create profile method.");
        //myBusiness.createProfile("Good Business", "The Best Business in the west!", "9 to 5");
        //myBusiness.createProfile("Tech Your Mom", "IT services and consulting", "11 AM - MIDNIGHT");
        //System.out.println("Profile created: " + myBusiness);

        // Test editProfile method
        //System.out.println("Testing edit profile method");
        //myBusiness.editProfile("Tech Your Mom Corp.", "IT services, consulting, and training", "9AM to NOON");
        //System.out.println("Profile edited: " + myBusiness);

        // Test createMeetup method
        //System.out.println("Testing create meetup method");
        //myBusiness.createMeetup("Tech Meetup", "Discussing the latest in tech", "2024-09-25", "10:00:00", "Tech Park");
        //System.out.println("Meetup created: " + myBusiness);

        // Test deleteProfile method
        //myBusiness.deleteProfile();
        //System.out.println("Profile deleted: " + myBusiness);

        //This will write to the MySQL Server.

        System.out.println("Saving myBusiness to the mySQL Database!");
        if (myBusiness.getName() != null && !myBusiness.getName().trim().isEmpty()) {
            businessDAO.saveBusiness(myBusiness);
            System.out.println("BUSINESS SAVED!!");
        } else {
            System.out.println("No new business created, DATABASE not saved!");
        }

        System.out.println("---------------------------------------------------------------------------------");

        //Reading from the MySQL Server
        System.out.println("Do you want to read from the database? (Y/N) ");
        String answer2 = scanner.nextLine().trim().toUpperCase();
        if (answer2.equals("Y")) {
            System.out.println("Preparing to reread from the mySQL Database!");
            System.out.println("========= Start OF DATABASE =============");
            businessDAO.readBusinesses();
            System.out.println("========== END OF DATABASE ==============");
        } else {
            System.out.println("Business Id: " + myBusiness.getBusinessId());
            System.out.println("Business Name: " + myBusiness.getName());
            System.out.println("Business Description: " + myBusiness.getDescription());
            System.out.println("Opening Times: " + myBusiness.getOpeningTimes());
            System.out.println("Location: " +myBusiness.getLocation());
            System.out.println(myBusiness.getProfileDetails());
        }

        //Deleting business from MySQL Server
        //System.out.println("Preparing to delete a business from the mySQL Database!");
        //System.out.println("_________________________________________________________________________________");
        //businessDAO.deleteBusiness(myBusiness.getBusinessId());
        //businessDAO.deleteBusiness(1724697);
        //businessDAO.deleteBusiness(1721722);
        //businessDAO.deleteBusiness(1721687);
        //businessDAO.deleteBusiness(1721171);

        //Checking to see that the business got removed
        System.out.println("Do you want to read from the database? (Y/N) ");
        String answer3 = scanner.nextLine().trim().toUpperCase();
        if (answer3.equals("Y")) {
            System.out.println("Preparing to reread from the mySQL Database!");
            System.out.println("========= Start OF DATABASE =============");
            businessDAO.readBusinesses();
            System.out.println("========== END OF DATABASE ==============");
        } else {
            System.out.println("DONE! ");
        }
        scanner.close();

        System.out.println("Preparing to generate IDFactory number!");
        System.out.println("_________________________________________________________________________________");
        System.out.println("Test IDFactory " + IDFactory.generateID());
    }
}
