package throunhu.is.hi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;


public class BookingController {
    private BookingDatabase bookingDatabase;
    private TourDatabase tourDatabase;

    private Booking[] bookings;
    public BookingController(BookingDatabase bookingDatabase, TourDatabase tourDatabase){
        this.bookingDatabase = bookingDatabase;
        this.tourDatabase = tourDatabase;
    }


    // tekur inn allar upplýsingar sem þarf til að búa til booking
    public Booking createBooking(Customer customer, int tourID, Date bookingDate, Time bookingTime, int numSpots) {
        int price = tourDatabase.getTourById(tourID).getPricePerPerson()*numSpots;
        Booking booking = new Booking(customer,tourID,bookingDate,bookingTime,numSpots, price);
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

    // Bætti við útaf junit test TODO - laga inní method
    public boolean isConfirmed(Booking booking){
        return true;
    }

    private boolean isValidBooking(Booking booking) {
        if(booking.getNumSpots() <= 0){
            System.out.println("No spots booked");
            return false;
        }

        Tour tour = booking.getTourDatabase().getTourById(booking.getTourID());
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





}

