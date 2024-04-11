package throunhu.is.hi;

import java.sql.*;


public class Booking {
    private int bookingID;
    private Customer customer;
    private int tourID;
    private Date bookingDate;
    private Time bookingTime;
    private int numSpots;
    private int price;
    private BookingDatabase bookingDatabase;
    private TourDatabase tourDatabase;

    public Booking(int bookingID, Customer customer, int tourID, Date bookingDate, Time bookingTime, int numSpots, int price, BookingDatabase bookingDatabase, TourDatabase tourDatabase) {
        this.bookingID = bookingID;
        this.customer = customer;
        this.tourID = tourID;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.numSpots = numSpots;
        this.price = price;
        this.bookingDatabase = bookingDatabase;
        this.tourDatabase = tourDatabase;
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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
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

    public void setTourDatabase(TourDatabase tourDatabase) {
        this.tourDatabase = tourDatabase;
    }

    public TourDatabase getTourDatabase() {
        return tourDatabase;
    }


    public void bookTour() {
        try {
            bookingDatabase.addBookingToDatabase(this);
            System.out.println("Booking successful.");
        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

    public void cancelBooking() {
        try {
            bookingDatabase.removeBooking(bookingID);
            System.out.println("Booking successfully cancelled.");
        } catch (SQLException e) {
            System.out.println("Error cancelling booking: " + e.getMessage());
        }
    }

}
