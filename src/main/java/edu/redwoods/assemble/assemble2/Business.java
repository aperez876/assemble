package edu.redwoods.assemble.assemble2;

public class Business {
    private int businessId;
    private String name;
    private String description;
    private String openingTimes;

    // Attributes for Meetup
    private int meetupId;
    private String meetupTitle;
    private String meetupDescription;
    private String meetupDate;
    private String meetupTime;
    private String meetupLocation;

    public void createProfile(int businessId, String name, String description, String openingTimes) {
        // Implementation here
        this.businessId = businessId;
        this.name = name;
        this.description = description;
        this.openingTimes = openingTimes;
    }

    public void setMeetupId(int meetupId) {
        this.meetupId = meetupId;
    }

    public void setMeetupTitle(String meetupTitle) {
        this.meetupTitle = meetupTitle;
    }

    public void setMeetupDescription(String meetupDescription) {
        this.meetupDescription = meetupDescription;
    }

    public void setMeetupDate(String meetupDate) {
        this.meetupDate = meetupDate;
    }

    public void setMeetupTime(String meetupTime) {
        this.meetupTime = meetupTime;
    }

    public void setMeetupLocation(String meetupLocation) {
        this.meetupLocation = meetupLocation;
    }


    // Method to create a meetup
    public void createMeetup(int meetupId, String title, String description, String date, String time, String location) {
        if (!time.matches("\\d{2}:\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Time must be in the format HH:MM:SS");
        }
        setMeetupId(meetupId);
        setMeetupTitle(title);
        setMeetupDescription(description);
        setMeetupDate(date);
        setMeetupTime(time);
        setMeetupLocation(location);
        System.out.println("Meetup created successfully!");
    }



    /*
     // Method to **CREATE A PROFILE**, probably to be implemented in another class:
     // maybe BusinessProfile.java(?)

    public void createProfile(int businessId, String name, String description, String openingTimes) {
        setBusinessId(businessId);
        setName(name);
        setDescription(description);
        setOpeningTimes(openingTimes);
        System.out.println("Profile created successfully!");
    }
    */

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOpeningTimes(String openingTimes) {
        this.openingTimes = openingTimes;
    }


    public void editProfile(int businessId, String name, String description, String openingTimes) {
        if (businessId != 0) {
            setBusinessId(businessId);
        }
        if (name != null && !name.isEmpty()) {
            setName(name);
        }
        if (description != null && !description.isEmpty()) {
            setDescription(description);
        }
        if (openingTimes != null && !openingTimes.isEmpty()) {
            setOpeningTimes(openingTimes);
        }
        System.out.println("Profile updated successfully!");
    }

    /*
    // Method to edit a profile
    public void editProfile(int businessId, String name, String description, String openingTimes) {
        if (businessId != 0) {
            setBusinessId(businessId);
        }
        if (name != null && !name.isEmpty()) {
            setName(name);
        }
        if (description != null && !description.isEmpty()) {
            setDescription(description);
        }
        if (openingTimes != null && !openingTimes.isEmpty()) {
            setOpeningTimes(openingTimes);
        }
        System.out.println("Profile updated successfully!");
    }
    */


    public void deleteProfile() {
        setBusinessId(0);
        setName("");
        setDescription("");
        setOpeningTimes("");
        setMeetupId(0);
        setMeetupTitle("");
        setMeetupDescription("");
        setMeetupDate("");
        setMeetupTime("");
        setMeetupLocation("");
        System.out.println("Profile deleted successfully!");
    }

    public void getProfile() {
        // Implementation here
    }

    public void createMeetup() {
        // Implementation here
    }

    public void notifyItemDrop() {
        // Implementation here
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", openingTimes='" + openingTimes + '\'' +
                ", meetupId=" + meetupId +
                ", meetupTitle='" + meetupTitle + '\'' +
                ", meetupDescription='" + meetupDescription + '\'' +
                ", meetupDate='" + meetupDate + '\'' +
                ", meetupTime='" + meetupTime + '\'' +
                ", meetupLocation='" + meetupLocation + '\'' +
                '}';
    }

    // Getter methods
    public int getBusinessId() {
        return businessId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }

    public int getMeetupId() {
        return meetupId;
    }

    public String getMeetupTitle() {
        return meetupTitle;
    }

    public String getMeetupDescription() {
        return meetupDescription;
    }

    public String getMeetupDate() {
        return meetupDate;
    }

    public String getMeetupTime() {
        return meetupTime;
    }

    public String getMeetupLocation() {
        return meetupLocation;
    }
    //an example on how to use these methods

    public static void main(String[] args) {


        Business business = new Business();
        business.createProfile(2,
                "Bookstore",
                "A place to find your favorite books",
                "9 AM - 9 PM");
        business.editProfile(2,
                "Updated Bookstore",
                "A place to find your favorite books and more",
                "9 AM - 10 PM");
        business.deleteProfile();
        business.createMeetup(1,
                "Java Programming Meetup",
                "A meetup for Java enthusiasts",
                "2024-09-25",
                "10:00 AM",
                "Coffee Shop");
    }
}
