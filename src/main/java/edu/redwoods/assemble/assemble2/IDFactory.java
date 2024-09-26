package edu.redwoods.assemble.assemble2;

public class IDFactory {
    //Method to create unique ID values based on the time
    //We should be able to use this for ProfileID, BusinessID, meetupID, and more!
    public static long generateID() {
        return System.currentTimeMillis() / 1000L;
    }
}
