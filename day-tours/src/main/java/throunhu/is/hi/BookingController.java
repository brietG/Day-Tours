package throunhu.is.hi;
import throunhu.is.hi.Booking;


public class BookingController {
    private Booking[] bookings;

    public void change(Booking booking) { 

    }
    public void cancel(Booking booking) { 

    }

    // veit ekki hvort við þurfum þetta fall eða hvort það sé bara að flækja málin :,)
    public Booking[] search(int bookingID) { 

        return null;

    }

    // tekur inn allar upplýsingar sem þarf til að búa til booking
    public Booking[] createBooking() { 

        return null;

    }
    public void addBooking() { 

    }
    // færði úr Customer
    public void confirmBooking(Booking booking){
        
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
        // Dagsetning í fortíðinni valin ?
        return true;
    }

    public void processBooking(Booking booking) {
        if (isValidBooking(booking)) {
            booking.bookTour();
        } else {
            System.out.println("Invalid booking.");
        }
    }

}

