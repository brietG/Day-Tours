package throunhu.is.hi;

import java.sql.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        // Initialize controllers and databases
        Database db = new Database();
        TourDatabase tourDatabase = new TourDatabase(db);
        CustomerDB customerDB = new CustomerDB();
        BookingDatabase bookingDatabase = new BookingDatabase();
        TourController tourController = new TourController(tourDatabase);
        BookingController bookingController = new BookingController(bookingDatabase,tourDatabase);

        // Scanner for input
        Scanner scanner = new Scanner(System.in);

        //Customer customer = new Customer(2020202, "Jóna", "email@ja.is", 121212);

        Connection conn = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        // Main interaction loop


        System.out.println("Welcome! Do you want to 'search' a trip or get 'all' trips?");

        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("search")) {
                System.out.println("Choose '1' if you want to search by any one attribute or choose '2' to search by location and date");
                System.out.println("Enter number:");
                String num = scanner.nextLine().trim();
                if (num.equals("1")) {
                    System.out.println("Enter your search query for type, name, date, or location:");
                    String query = scanner.nextLine();
                    // Assuming a method exists to handle single attribute searches
                    List<Tour> tours = tourDatabase.searchTours(query);
                    displayTours(tours);
                } else if (num.equals("2")) {
                    System.out.println("Enter the location:");
                    String location = scanner.nextLine();
                    System.out.println("Enter the date (YYYY-MM-DD):");
                    String date = scanner.nextLine();
                    // Assuming a method exists to handle searches by location and date
                    List<Tour> tours = tourDatabase.searchTourbyDateandLoc(location, date);
                    displayTours(tours);
                } else {
                    System.out.println("Invalid selection. Please enter '1' or '2'.");
                    continue;
                }
                break; // Exit after processing
            } else if (input.equals("all")) {
                List<Tour> tours = tourDatabase.getAllTours();
                if (tours.isEmpty()) {
                    System.out.println("No tours available.");
                } else {
                    displayTours(tours);
                }
                break; // Exit after processing
            } else {
                System.out.println("Invalid input. Please enter 'search' or 'all'.");
            }

            }
        System.out.println("Do you want to book a tour? (yes/no)");
        String input = scanner.nextLine().toLowerCase().trim();
        if (input.equals("yes")) {

            // Gather customer information

            System.out.println("Enter your details:");
            System.out.println("Kennitala:");
            int kennitala = Integer.parseInt(scanner.nextLine());
            System.out.println("Name:");
            String name = scanner.nextLine();
            System.out.println("Email:");
            String email = scanner.nextLine();
            System.out.println("Phone:");
            int phone = Integer.parseInt(scanner.nextLine());

            // Create customer object
            Customer customer = new Customer(kennitala, name, email, phone);

            // Add customer to database
            customerDB.addCustomer(customer);
        }



        // Close scanner
        scanner.close();
    }

    private static void displayTours(List<Tour> tours) {
        if (tours.isEmpty()) {
            System.out.println("No tours found with the given query.");
        } else {
            for (Tour tour : tours) {
                tour.getInfo();
            }
        }
    }


}