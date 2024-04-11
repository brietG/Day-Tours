package throunhu.is.hi;
import throunhu.is.hi.Booking;


public class BookingController {
    

    private Booking[] bookings;

    public void change(Booking booking) { 

    }
    public void cancel(Booking booking) { 

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

    public void processBooking(Booking booking) {
        if (isValidBooking(booking)) {
            booking.bookTour();
        } else {
            System.out.println("Invalid booking.");
        }
    }

}

