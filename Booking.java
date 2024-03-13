import java.util.Date;

public class Booking {
    private int bookingID;
    private String customer;
    private String tour;
    private Date date;
    private String time; 
    private int numSpots;
    private int price;

    public Booking(int bookingID, String customer, String tour, Date date, String time, int numSpots, int price) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
    public void change(String book) {
       
    }
}
