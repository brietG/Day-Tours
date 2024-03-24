// package test; (veit ekki hvort við þurfum þetta. Vscode setti þetta inn)

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class BookingControllerTest {
    private BookingController bookingController;
    private Booking booking;
    private Customer customer;

    @Before
    public void setUp() {
        // Fyrir Tour
        // Skoða tour
        String location = "Kringlan";
        double duration = 1.5;
        int pricePerPerson = 100;
        String type = "Shopping";
        Date dates = Date.valueOf(LocalDate.now());
        String timeOfTour = "12:00";

        // Fyrir Booking
        int bookingID = 1;
        LocalDate date = LocalDate.of(2024, 1, 1);
        LocalTime time = LocalTime.of(12, 0);
        int numSpots = 2;
        int price = 100;
        Tour tour = new Tour(location, duration, pricePerPerson, type, dates, timeOfTour);
        
        // Fyrir Customer
        int kennitala;
        String name;
        String email;
        int phone;

        bookingController = new BookingController();
        booking = new Booking(bookingID, customer, tour, date, time, numSpots, price);
        customer = new Customer(kennitala, name, email, phone);
    }

    @Test
    public void testChange() {
        bookingController.change(booking);

        // Gerum assert skipun hérna:
        // assertTrue();
    }

    @Test
    public void testCancel() {
        bookingController.cancel(booking);

        // Assert skipun hérna
        // assertTrue();
    }

    @Test
    public void testSearch() {
        int bookingID = 123;

        Booking[] bookings = bookingController.search(bookingID);

        // Chekka á þessu
        assertNotNull(bookings);
    }

    @Test
    public void testCreateBooking() {
        Booking[] bookings = bookingController.createBooking();

        // chekka á þessu
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
        bookingController.confirmBooking(booking);

        // Assert skipun hér
        // assertTrue();
    }
}