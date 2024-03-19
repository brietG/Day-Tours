import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int bookingID;
    private String customer;
    private String tour;
    private LocalDate date;
    private LocalTime time; 
    private int numSpots;
    private int price;

    public Booking(int bookingID, String customer, String tour, LocalDate date, LocalTime time, int numSpots, int price) {
        this.bookingID = bookingID;
        this.customer = customer;
        this.tour = tour;
        this.date = date;
        this.time = time;
        this.numSpots = numSpots;
        this.price = price;
    }

    // Getterar og Setterar
    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    // Method - TODO - Setja inn kóða
    public void bookTour() {
       
    }
}

/* Hægt að sleppa getterum og setterum og setja þetta upp svona
public class Booking {
    private int bookingID;
    private String customer;
    private String tour;
    private Date date;
    private String time;
    private int numSpots;
    private int price;

    public void bookTour() { 

    }
}
*/