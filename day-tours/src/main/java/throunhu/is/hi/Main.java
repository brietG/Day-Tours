package throunhu.is.hi;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        BookingDatabase bookingDatabase = new BookingDatabase();
        Customer customer = new Customer(1020202, "John Doe","joi@dd", 33333); // Assuming a Customer constructor

        Booking booking = new Booking(0, customer, , LocalDate.now(), LocalTime.now(), 2, 200, bookingDatabase);

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