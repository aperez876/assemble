package edu.redwoods.assemble.assemble2;

    /*
    This Java code generates unique ID values based on the current time.
    These IDs can be used for various purposes like ProfileID, BusinessID, meetupID, etc
    */

// Method to create unique ID values based on the time
// We should be able to use this for ProfileID, BusinessID, meetupID, and more!


public class IDFactory {

    public static long generateID() {
        String timestamp = String.valueOf(System.currentTimeMillis() / 1L);
        // Truncate the some digits
        int start = 3;
        int end = 9;
        String truncatedTimestamp = timestamp.substring(0, start) + timestamp.substring(end);
        return Long.parseLong(truncatedTimestamp);
    }

    public static void main(String[] args) {
        //System.out.println(generateID());
    }
}
