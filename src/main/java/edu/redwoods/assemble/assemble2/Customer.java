package edu.redwoods.assemble.assemble2;

import java.util.List;

    /*
    This code defines a Customer class that represents a customer with an ID and a name.
    The class includes methods for sending notifications, printing notifications,
    and placeholders for other actions like following or unfollowing a business
    */

public class Customer {

    private int customerId;
    private String name;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void sendNotification(String message) {
        Notification notification = new Notification(Notification.generateId(), this.customerId, message);
        notification.sendNotification();
    }

    public void printNotifications() {
        List<Notification> notifications = Notification.getNotifications(this.customerId);
        System.out.println("Notifications for " + this.name + ":");
        for (Notification notification : notifications) {
            System.out.println(notification.message + " at " + notification.timestamp);
        }
    }


    public void followBusiness() {
        // Implementation here
    }

    public void unfollowBusiness() {
        // Implementation here
    }

    public void viewBusinessProfile() {
        // Implementation here
    }

    public void receiveNotification() {
        // Implementation here
    }

    //for testing purposes only!!
    public static void main(String[] args) {
        Customer customer1 = new Customer(101, "Alice");
        Customer customer2 = new Customer(102, "Bob");

        customer1.sendNotification("Welcome to our service, Alice!");
        customer2.sendNotification("Welcome to our service, Bob!");
        customer1.sendNotification("Your order has been shipped.");

        customer1.printNotifications();
        customer2.printNotifications();
    }


}