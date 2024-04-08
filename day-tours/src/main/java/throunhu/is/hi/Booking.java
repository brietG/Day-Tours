package throunhu.is.hi;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int bookingID;
    private Customer customer;
    private int tourID;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private int numSpots;
    private int price;

    public Booking(int bookingID, Customer customer, int tourID, LocalDate bookingDate, LocalTime bookingTime, int numSpots, int price) {
        this.bookingID = bookingID;
        this.customer = customer;
        this.tourID = tourID;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.numSpots = numSpots;
        this.price = price;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getNumSpots() {
        return numSpots;
    }

    public void setNumSpots(int numSpots) {
        this.numSpots = numSpots;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void bookTour() {
        // Perform validation checks
        if (!isValidBooking()) {
            System.out.println("Invalid booking.");
            return;
        }

        // Perform database update
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Bookings (customerID, tourID, bookingDate, bookingTime, numSpots, price) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setInt(1, customer.getKennitala());
            stmt.setInt(2, tourID);
            stmt.setDate(3, Date.valueOf(bookingDate));
            stmt.setTime(4, Time.valueOf(bookingTime));
            stmt.setInt(5, numSpots);
            stmt.setInt(6, price);
            stmt.executeUpdate();
            System.out.println("Booking successful.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to book the tour.");
        }
    }

    private boolean isValidBooking() {
        // Implement your validation logic here (e.g., check availability)
        // Return true if the booking is valid; false otherwise
        return true; // Placeholder for demonstration
    }
}
