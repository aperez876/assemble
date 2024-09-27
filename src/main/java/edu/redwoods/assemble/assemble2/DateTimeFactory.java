package edu.redwoods.assemble.assemble2;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//Factory to make sure dates and times are compatible with sql

public class DateTimeFactory {

    // Method to prompt user for a valid date
    public static Date promptForDate(Scanner scanner) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter monthDayFormatter = DateTimeFormatter.ofPattern("MM-dd");
        while (true) {
            System.out.print("Enter a date (yyyy-MM-dd or MM-dd): ");
            String dateInput = scanner.nextLine();
            try {
                LocalDate date;
                if (dateInput.matches("\\d{2}-\\d{2}")) {
                    // If the input is in MM-dd format, append the current year
                    dateInput = LocalDate.now().getYear() + "-" + dateInput;
                }
                date = LocalDate.parse(dateInput, dateFormatter);
                return Date.valueOf(date);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
    }

    // Method to prompt user for a valid time
    public static Time promptForTime(Scanner scanner) {
        DateTimeFormatter[] timeFormatters = {
                DateTimeFormatter.ofPattern("HH:mm:ss"),
                DateTimeFormatter.ofPattern("HH:mm"),
                DateTimeFormatter.ofPattern("h:mm a"), // handles 1 or 2 digit hour with AM/PM
                DateTimeFormatter.ofPattern("hh:mm:ss a"),
                DateTimeFormatter.ofPattern("hha"),
                DateTimeFormatter.ofPattern("hh a"),
                DateTimeFormatter.ofPattern("h a"),
                DateTimeFormatter.ofPattern("ha")
        };
        while (true) {
            System.out.print("Enter a time (HH:mm:ss, HH:mm, h:mm a, hh:mm:ss a, hha, hh a, h a, or ha): ");
            String timeInput = scanner.nextLine().trim().toUpperCase();

            // Ensure there's a space between the time and AM/PM if missing
            if (timeInput.matches(".*[AP][M]$")) {
                timeInput = timeInput.substring(0, timeInput.length() - 2) + " " + timeInput.substring(timeInput.length() - 2);
            }

            try {
                LocalTime time = null;
                for (DateTimeFormatter formatter : timeFormatters) {
                    try {
                        time = LocalTime.parse(timeInput, formatter);
                        break;
                    } catch (DateTimeParseException e) {
                        // Continue to the next formatter
                    }
                }
                if (time == null) {
                    throw new DateTimeParseException("Invalid time format", timeInput, 0);
                }
                // Default seconds to 00 if not provided
                if (timeInput.matches("\\d{1,2}:\\d{2}([ ]?[AP][Mm])?") || timeInput.matches("\\d{1,2}[AP][Mm]") || timeInput.matches("\\d{1,2} [AP][Mm]") || timeInput.matches("\\d{1,2}[AP][Mm]")) {
                    time = time.withSecond(0);
                }
                return Time.valueOf(time);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please try again.");
            }
        }
    }

    //Method to display date in a human-readable form


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example usage for date
        Date sqlDate = DateTimeFactory.promptForDate(scanner);
        System.out.println("Parsed SQL Date: " + sqlDate);

        // Example usage for time
        Time sqlTime = DateTimeFactory.promptForTime(scanner);
        System.out.println("Parsed SQL Time: " + sqlTime);

        scanner.close();
    }
}