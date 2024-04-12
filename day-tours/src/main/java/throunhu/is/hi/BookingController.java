package throunhu.is.hi;

import throunhu.is.hi.Booking;

public class BookingController {
    // private Booking[] bookings;

    private List<Booking> bookings;

    public bookingController(){
        this.bookings = new ArrayList<>();  
    }

    public void change(Booking booking) { 

    }
    public void cancel(Booking booking) { 

    }

    // TODO -tekur inn allar upplýsingar sem þarf til að búa til booking
    public Booking[] createBooking() { 

        return null;
    }

    public void addBooking() { 

    }

    // Bætti við þessum getter - gætum alveg sleppt honum:
    public List<Booking> getBookings() {
        return bookings;
    }

    // TODO -veit ekki hvort við þurfum þessar aðferðir.

    // færði úr Customer
    public void confirmBooking(Booking booking){
        
    }

    // Bætti við útaf junit test TODO - laga inní method
    public boolean isConfirmed(Booking booking){
        return true;
    }
}
