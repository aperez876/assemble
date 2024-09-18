package edu.redwoods.assemble.assemble2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notification {
    private int notificationId;
    private int customerId;
    private String message;
    private Date timestamp;

    private static List<Notification> notifications = new ArrayList<>(); //List to store notifications.

    //Constructor
    public Notification(int notificationId, int customerId, String message){
        this.notificationId = notificationId;
        this.customerId = customerId;
        this.message = message;
        this.timestamp = new Date();
    }

    //Method to send notfications
        public void sendNotification() {
        notifications.add(this);
        System.out.println("Notification sent: " + this.message);
    }

    //Method to get notifications
    public void getNotifications() {
        // Implementation here
    }

    //Method to get all notifications for a specific user.
    public static List<Notification> getNotifications(int customerId) {
        List<Notification> customerNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.customerId == customerId) {
                customerNotifications.add(notification);
                }
        }
        return customerNotifications;
    }
// Main method for testing
public static void main(String[] args) {
    Notification notification1 = new Notification(1001, 101, "You have subscribed to Gardens Gate Cardshop.");
    Notification notification2 = new Notification(1002, 102, "You have unsuscribed from KB Toys.");
    Notification notification3 = new Notification(1003, 101, "Your order has been delivered.");

    notification1.sendNotification();
    notification2.sendNotification();
    notification3.sendNotification();

    List<Notification> notificationsForCustomer101 = Notification.getNotifications(101);
    System.out.println("Notifications for customer 101:");
    for (Notification notification : notificationsForCustomer101) {
        System.out.println(notification.message + " at " + notification.timestamp);
    }
}
}