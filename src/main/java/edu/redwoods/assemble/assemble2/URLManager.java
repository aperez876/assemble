package edu.redwoods.assemble.assemble2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class URLManager {
    private List<String> urlList;

    public URLManager() {
        urlList = new ArrayList<>();
    }

    // Method to add a URL to the list
    public void addURL(String url) {
        urlList.add(url);
    }

    // Method to retrieve the URL list
    public List<String> getURLList() {
        return urlList;
    }

    // Method to print all URLs
    public void printURLs() {
        for (String url : urlList) {
            System.out.println(url);
        }
    }

    // Method to save the URL list to a file (append mode)
    public void saveURLsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (String url : urlList) {
                writer.write(url);
                writer.newLine();
            }
            System.out.println("URLs appended to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving URLs to file: " + e.getMessage());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        URLManager urlManager = new URLManager();
        //urlManager.addURL("https://www.example.com");
        //urlManager.addURL("https://www.anotherexample.com");
        //urlManager.addURL("https://www.somemoreexample.com");

        urlManager.printURLs();

        urlManager.saveURLsToFile("urls.txt");
    }
}
