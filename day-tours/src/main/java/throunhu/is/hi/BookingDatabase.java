package throunhu.is.hi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDatabase {
    private Connection connectionToDb() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:DayTours.db");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    private void closeConnection(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public List<Booking> getBooking(int bookingID) {
        Connection conn = connectionToDb();
        ArrayList<Booking> bookings = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Bookings WHERE bookingID = " + bookingID);
            while (rs.next()) {
                int customerID = rs.getInt("customerID");
                int tourID = rs.getInt("tourID");
                Date bookingDate = rs.getDate("bookingDate");
                Time bookingTime = rs.getTime("bookingTime");
                int numSpots = rs.getInt("numSpots");
                int price = rs.getInt("price");
                Booking booking = new Booking(customerID, null, tourID, bookingDate, bookingTime, numSpots, price, null, null);
                bookings.add(booking);
            }
            rs.close();
            stmt.close();
            closeConnection(conn);
            return bookings;
        } catch (SQLException e) {
            System.out.println("Error getting booking: " + e.getMessage());
            return null;
        }

    }


    public void addBookingToDatabase(Booking booking) throws SQLException {
        Connection conn = connectionToDb();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Bookings (customerID, tourID, bookingDate, bookingTime, numSpots, price) VALUES (" + booking.getCustomer() + ", " + booking.getTourID() + ", '" + booking.getBookingDate() + "', '" + booking.getBookingTime() + "', " + booking.getNumSpots() + ", " + booking.getPrice() + ")");
            stmt.close();
            closeConnection(conn);
        } catch (SQLException e) {
            System.out.println("Error adding booking: " + e.getMessage());
        }
    
    }


    public void removeBooking(int bookingID) {
        Connection conn = connectionToDb();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Bookings WHERE bookingID = " + bookingID);
            stmt.close();
            closeConnection(conn);
        } catch (SQLException e) {
            System.out.println("Error removing booking: " + e.getMessage());
        }
    }



    public void update (Booking booking){

    }
}