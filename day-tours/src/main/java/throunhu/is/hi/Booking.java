package throunhu.is.hi;

//import java.nio.channels.CancelledKeyException;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;


public class Booking {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private int bookingID;
    private Customer customer;
    private int tourID;
    private Date bookingDate;
    private Time bookingTime;
    private int numSpots;
    private int price;
    private BookingDatabase bookingDatabase;
    private TourDatabase tourDatabase;
    private TourController tourController;
    private Database db;
    private CustomerDB customerDB;

    public Booking(Customer customer, int tourID, Date bookingDate, Time bookingTime, int numSpots, int price) {
        this.bookingID = ID_GENERATOR.getAndIncrement();
        this.customer = customer;
        this.tourID = tourID;
        this.bookingDate = Date.valueOf(bookingDate.toLocalDate());
        this.bookingTime = Time.valueOf(bookingTime.toLocalTime());
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

    //á að tengjast við decrement í tourDatabase og kalla á hann til að minnka sæti í limitspots 
    //svo fjöldi limitspots minnki um fjölda sæta sem bókuð eru

    public int addSpot() {
        return numSpots++;
    }

    public static Booking bookTour(BookingDatabase bookingDatabase, Customer customer) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID of the tour you would like to book:");
        int tourID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of spots you want to book:");
        int numSpots = Integer.parseInt(scanner.nextLine());

        int pricePerPerson = bookingDatabase.getPricePerPerson(tourID);
        // Calculate total price
        int totalPrice = numSpots * pricePerPerson;

        // Assuming bookingDate and bookingTime are available as instance variables
        LocalDate localDate = LocalDate.now(); // Example current date
        LocalTime localTime = LocalTime.now(); // Example current time

        // Close scanner
        scanner.close();

        return new Booking(customer, tourID, Date.valueOf(localDate), Time.valueOf(localTime), numSpots, totalPrice);
    }


}
