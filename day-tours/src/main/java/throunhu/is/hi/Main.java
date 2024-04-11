package throunhu.is.hi;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TourController tourController = new TourController();
        BookingController bookingController = new BookingController();
        TourDatabase tourDatabase = new TourDatabase();
        
        
        List<Tour> allTours = tourController.getAllTours();
        for (Tour tour : allTours) {
            tour.getInfo();
        }
/* 
        Tour[] tours = tourController.searchTours("Horse");
        for (Tour tour : tours) {
            tour.getInfo();
        }
        */

        System.out.println("Hello world!");
        BookingDatabase bookingDatabase = new BookingDatabase();

        Customer customer = new Customer(1020202, "John Doe","joi@dd", 33333); // Assuming a Customer constructor

        Booking booking = new Booking(1, customer, 4, "2024-06-17", "12:00:00", 2, 4000, bookingDatabase, tourDatabase);

        //Booking booking = new Booking(1, customer, 4, "2024-06-17", "12:00:00", 2, 4000, bookingDatabase, tourDatabase);

        
        //Tour tour1 = new Tour(/* Tour details */);
        //Tour tour2 = new Tour(/* Tour details */);
        //tourController.addTour(tour1);
        //tourController.addTour(tour2);
        

        try {
            // Adding a booking
            bookingDatabase.addBookingToDatabase(booking);
            // Optionally, remove a booking
            // bookingDatabase.removeBooking(1); // Assuming the booking ID is 1
        } catch (SQLException e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    
    }
}