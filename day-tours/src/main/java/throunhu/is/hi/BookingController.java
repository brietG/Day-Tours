package throunhu.is.hi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;

public class BookingController {
    private BookingDatabase bookingDatabase;
    private TourDatabase tourDatabase;
    // private Booking[] bookings;

    private List<Booking> bookings; 

    public BookingController(BookingDatabase bookingDatabase, TourDatabase tourDatabase){
        this.bookingDatabase = bookingDatabase;
        this.tourDatabase = tourDatabase;
        this.bookings = new ArrayList<>();
    }

    public void charge(Booking booking) {
        booking.setPrice(booking.getNumSpots()* booking.getTour().getPricePerPerson());
    }

    // Þetta ætti að virka þegar við notum arraylist í staðinn fyrir array
    public void cancel(Booking booking) { 
        bookings.remove(booking); 
    }
    /*
    public void cancel(Booking booking) { 
        if (bookings != null && booking != null) {
            for (int i = 0; i < bookings.length; i++) {
                if (bookings[i] != null && bookings[i].equals(booking)) {
                    // Found the booking, remove it by shifting the array elements
                    for (int j = i; j < bookings.length - 1; j++) {
                        bookings[j] = bookings[j + 1];
                    }
                    bookings[bookings.length - 1] = null; // Set the last element to null
                    break; // Exit the loop
                }
            }
        }
    }
    */

    // TODO - Skoða virknina og hvað er tekið inn
    public Booking createBooking(Customer customer, Tour tour, Date bookingDate, Time bookingTime, int numSpots) {
        Booking booking = new Booking(customer,tour,bookingDate,bookingTime,numSpots);
        charge(booking);
        return booking;
    }
    
    
    //á að tengjast við decrement í tourDatabase og kalla á hann til að minnka sæti í limitspots 
    //svo fjöldi limitspots minnki um fjölda sæta sem bókuð eru
    public boolean confirmBooking(Booking booking) {
        if (booking == null || !isValidBooking(booking)) {
            System.out.println("Invalid booking.");
            return false;
        }
        try {
            booking.bookTour();
            System.out.println("Booking confirmed and spots updated.");
            return true;
        } catch (Exception e) {
            System.out.println("Booking confirmation failed: " + e.getMessage());
            return false;
        }

    }


    // Bætti við útaf junit test TODO - laga inní method, þarf þetta?
    public boolean isConfirmed(Booking booking){
        return true;
    }

    private boolean isValidBooking(Booking booking) {
        if(booking.getNumSpots() <= 0){
            System.out.println("No spots booked");
            return false;
        }

        Tour tour = booking.getTourDatabase().getTourByDetails(String.valueOf(booking.getTourID()));
        if (tour == null) {
            System.out.println("Tour not found.");
            return false;
        }

        if (!tour.getSpaceAvailable() || tour.getLimitSpots() < booking.getNumSpots()) {
            System.out.println("Not enough available spots for booking.");
            return false;
        }

        return true;
        // Dagsetning í fortíðinni valin ?
        
    }

    /* 
    public void processBooking(Booking booking) {
        if (isValidBooking(booking)) {
            booking.bookTour();
        } else {
            System.out.println("Invalid booking.");
        }
    }
    */

    // public void addBooking() { } - processBooking nóg?
    // public void change(Booking booking) { }
}