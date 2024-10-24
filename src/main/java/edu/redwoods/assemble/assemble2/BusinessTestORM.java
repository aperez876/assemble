package edu.redwoods.assemble.assemble2;

import org.hibernate.Session;

import java.util.List;

public class BusinessTestORM {
    public static void main(String[] args) {
        //TESTING NEW HIBERNATE SESSION CONNECTION
        Session session = HibernateUtil.getSessionFactory().openSession();

        //List Businesses
        List<BusinessEntity> businesses = session.createQuery("FROM BusinessEntity", BusinessEntity.class).list();
        for (BusinessEntity business : businesses) {
            System.out.println("Business ID: " + business.getBusinessId());
            System.out.println("Name: " + business.getName());
            System.out.println("Description: " + business.getDescription());
            System.out.println("Opening Times: " + business.getOpeningTimes());
            System.out.println("-------------------------------");
        }

        // Fetch Meetup entities
        List<Meetup> meetups = session.createQuery("FROM Meetup", Meetup.class).list();
        for (Meetup meetup : meetups) {
            System.out.println("Meetup ID: " + meetup.getId());
            System.out.println("Name: " + meetup.getName());
            System.out.println("Description: " + meetup.getDescription());
            System.out.println("Location: " + meetup.getLocation());
            System.out.println("-------------------------------");
        }

        // Close the session
        session.close();


        //scanner.close();
    }
}
