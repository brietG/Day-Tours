// package test; (veit ekki hvort við þurfum þetta. Vscode setti þetta inn)

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingControllerTest {
    private BookingController bookingController;
    private Booking booking;
    private Customer customer;

    @Before
    public void setUp() {
        // Fyrir Booking
        int bookingID = 321;
        LocalDate bookingDate = LocalDate.of(2024, 1, 1);
        LocalTime bookingTime = LocalTime.of(12, 0);
        int numSpots = 2;
        int price = 100;
        int tourID = 123;

        // Fyrir Customer
        int kennitala = 1123456789;
        String name = "Jón Jónsson";
        String email = "jonbesti@gmail.com";
        int phone = 6961234;

        bookingController = new BookingController();
        booking = new Booking(bookingID, customer, tourID, bookingDate, bookingTime, numSpots, price);
        customer = new Customer(kennitala, name, email, phone);
    }

    @Test
    public void testChange() {
        // TODO - skoða virknina á change fallinu
        LocalDate originalDate = booking.getBookingDate();
        bookingController.change(booking);

        assertNotEquals(originalDate, booking.getBookingDate());
    }

    @Test
    public void testCancel() {
        // Þurfum að búa til getBookings method
        int initialNumBookings = bookingController.getBookings().length;
        bookingController.cancel(booking);
        Booking[] updatedBookings = bookingController.getBookings();

        assertEquals(initialNumBookings - 1, updatedBookings.length);
    }

    @Test
    public void testSearch() {
        int bookingID = 321;

        Booking[] bookings = bookingController.search(bookingID);

        assertNotNull(bookings);
    }

    @Test
    public void testCreateBooking() {
        Booking newBooking = bookingController.createBooking();      

        assertNotNull(newBooking.getBookingID());
        assertNotNull(newBooking.getCustomer());
        assertNotNull(newBooking.getTourID());
        assertNotNull(newBooking.getBookingDate());
        assertNotNull(newBooking.getBookingTime());
        assertNotNull(newBooking.getNumSpots());
        assertNotNull(newBooking.getPrice());
    }

    @Test
    public void testAddBooking() {
        int initialSize = bookingController.getBookings().length;
        bookingController.addBooking();
        int newSize = bookingController.getBookings().length;

        assertEquals(initialSize + 1, newSize);
    }

    @Test
    public void testConfirmBooking() {
        bookingController.confirmBooking(booking);

        assertTrue(booking.isConfirmed());
    }
}