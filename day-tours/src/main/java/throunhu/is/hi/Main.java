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
        TourController tourController = new TourController();
        BookingController bookingController = new BookingController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Do you want to 'search' a trip or get 'all' trips?");
        String input = scanner.nextLine();
        
        if (input.equalsIgnoreCase("search")) {
            System.out.println("Enter your search query:");
            String query = scanner.nextLine();
            Tour[] tours = tourController.searchTours(query);
            for (Tour tour : tours) {
                tour.getInfo();
            }
        } else if (input.equalsIgnoreCase("all")) {
            List<Tour> tours = tourController.getAllTours();
            for (Tour tour : tours) {
                tour.getInfo();
            }
        } else {
            System.out.println("Invalid input. Please enter 'search' or 'all'.");
        }



/* 
        List<Tour> allTours = tourController.getAllTours();
        for (Tour tour : allTours) {
            tour.getInfo();
        }

        Tour[] tours = tourController.searchTours("Horse");
        for (Tour tour : tours) {
            tour.getInfo();
        }
    
*/
        /* 
        BookingDatabase bookingDatabase = new BookingDatabase();
        Customer customer = new Customer(1020202, "John Doe","joi@dd", 33333); // Assuming a Customer constructor

        Booking booking = new Booking(1, customer, 4, LocalDate.now(), LocalTime.now(), 2, 200, bookingDatabase);

        try {
            // Adding a booking
            bookingDatabase.addBookingToDatabase(booking);
            // Optionally, remove a booking
            // bookingDatabase.removeBooking(1); // Assuming the booking ID is 1
        } catch (SQLException e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    }*/
}

}