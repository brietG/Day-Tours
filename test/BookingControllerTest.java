// package test; (veit ekki hvort við þurfum þetta. Vscode setti þetta inn)

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookingControllerTest {
    private BookingController bookingController;

    @Before
    public void setUp() {
        bookingController = new BookingController();
    }

    @Test
    public void testChange() {
        // setjum inntak hér inn
        Booking booking = new Booking( );

        bookingController.change(booking);

        // gerum hérna assert skipun. eitthvað eins og:
        // assertTrue(blabla);
    }

    @Test
    public void testCancel() {
        // setjum inntak hér inn
        Booking booking = new Booking();

        bookingController.cancel(booking);

        // Setjum assert skipun hér líka
        // assertTrue(blabla);
    }

    @Test
    public void testSearch() {
        int bookingID = 123;

        // TODO -athuga með þetta :,)
        Booking[] bookings = bookingController.search(bookingID);

        assertNotNull(bookings);
    }

    @Test
    public void testCreateBooking() {
        Booking[] bookings = bookingController.createBooking();

        assertNotNull(bookings);
    }

    @Test
    public void testAddBooking() {
        bookingController.addBooking();

        // Setjum inn assert skipun hér lika
        // assertTrue(blabla);
    }

    @Test
    public void testConfirmBooking() {
        Booking booking = new Booking();

        bookingController.confirmBooking(booking);

        // Assert skiðun hér
        // assertTrue();
    }
}