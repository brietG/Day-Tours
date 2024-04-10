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

    private BookingDatabase bookingDatabase;

    public Booking(int bookingID, Customer customer, int tourID, LocalDate bookingDate, LocalTime bookingTime, int numSpots, int price, BookingDatabase bookingDatabase) {
        this.bookingID = bookingID;
        this.customer = customer;
        this.tourID = tourID;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.numSpots = numSpots;
        this.price = price;
        this.bookingDatabase = bookingDatabase;
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


    private boolean isValidBooking() {
        if(numSpots <= 0){
            System.out.println("No spots booked");
            return false;
        }
        // Dagsetning í fortíðinni valin ?
        return true;
    }

    public void bookTour() {
        // Perform validation checks
        if (!isValidBooking()) {
            System.out.println("Invalid booking.");
            return;
        }
        try {
            bookingDatabase.addBookingToDatabase(this);
            System.out.println("Booking successful.");
        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }


}
