package throunhu.is.hi;
import throunhu.is.hi.Booking;


public class BookingController {
    

    private Booking[] bookings;

    public void change(Booking booking) { 

    }

    //cancel booking veit ekki hvort er rétt á eftir að testa
    public void cancel(Booking booking) { 
        try {
            booking.cancelBooking();
        } catch (Exception e) {
            System.out.println("Error cancelling booking: " + e.getMessage());
        }
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

