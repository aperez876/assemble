package edu.redwoods.assemble.assemble2;

/*public class IDFactory {
    //Method to create unique ID values based on the time
    //We should be able to use this for ProfileID, BusinessID, meetupID, and more!
    public static long generateID() {
        return System.currentTimeMillis() / 1000L;
    }
}*/
public class IDFactory {
    // Method to create unique ID values based on the time
    // We should be able to use this for ProfileID, BusinessID, meetupID, and more!
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
