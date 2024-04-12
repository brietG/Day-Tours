package throunhu.is.hi;

import java.nio.channels.CancelledKeyException;
import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Booking {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private int bookingID;
    private Customer customer;
    private Tour tour;
    //private int tourID;
    private Date bookingDate;
    private Time bookingTime;
    private int numSpots;
    private int price;
    private BookingDatabase bookingDatabase;
    private TourDatabase tourDatabase;
    private TourController tourController;

    public Booking(Customer customer, Tour tour, Date bookingDate, Time bookingTime, int numSpots) {
        this.bookingID = ID_GENERATOR.getAndIncrement();
        this.customer = customer;
        //this.tourID = tourID;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.numSpots = numSpots;
        this.tour = tour;
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

   /*public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }*/

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

   public Tour getTour(){
        return tour;
   }
    //á að tengjast við decrement í tourDatabase og kalla á hann til að minnka sæti í limitspots 
    //svo fjöldi limitspots minnki um fjölda sæta sem bókuð eru

    public int addSpot() {
        return numSpots++;
    }

    public void bookTour() {
        Connection conn = null;
        try {
            conn = Database.getConnection();
            bookingDatabase.addBookingToDatabase(this);
            tourController.decrementAvailableSpots(this);
            conn.commit();
            System.out.println("Booking successful.");
        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }



}
