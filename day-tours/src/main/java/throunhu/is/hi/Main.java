package throunhu.is.hi;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import throunhu.is.hi.TourController;
import throunhu.is.hi.BookingController;
import throunhu.is.hi.Tour;


public class Main {
    public static void main(String[] args) {
        // Initialize controllers and databases
        TourDatabase tourDatabase = new TourDatabase();
        BookingDatabase bookingDatabase = new BookingDatabase();
        TourController tourController = new TourController(tourDatabase);
        BookingController bookingController = new BookingController(bookingDatabase,tourDatabase);

        // Scanner for input
        Scanner scanner = new Scanner(System.in);

        // Sample customer data
        Customer customer = new Customer(2020202, "Jóna", "email@ja.is", 121212);

        // Main interaction loop
        System.out.println("Welcome! Do you want to 'search' a trip or get 'all' trips?");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("search")) {
                System.out.println("Enter your search query:");
                String query = scanner.nextLine();
                Tour[] tours = tourController.searchTours(query);
                if (tours.length > 0) {
                    for (Tour tour : tours) {
                        tour.getInfo();
                    }
                } else {
                    System.out.println("No tours found with the given query.");
                }
                break; // Exit after processing
            } else if (input.equalsIgnoreCase("all")) {
                List<Tour> tours = tourController.getAllTours();
                if (tours.isEmpty()) {
                    System.out.println("No tours available.");
                } else {
                    for (Tour tour : tours) {
                        tour.getInfo();
                    }
                }
                break; // Exit after processing
            } else {
                System.out.println("Invalid input. Please enter 'search' or 'all'.");
            }
        }
        scanner.close();

    }
}