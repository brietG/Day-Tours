package throunhu.is.hi;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import throunhu.is.hi.TourController;

public class BookingDatabase {

    private Connection getConnection()  {
        URL res = getClass().getClassLoader().getResource("DayTours.db");
        if (res == null) {
            throw new RuntimeException("Database file not found");
        }
        String url = "jdbc:sqlite:" + res.getPath();
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
            throw new RuntimeException("Cannot connect to the database", e);
        }
        return conn;
    }

    private void closeConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        }
        catch(SQLException e) {
            System.err.println(e);
        }

    }



    public int getPricePerPerson(int tourID) {
        String getPriceSQL = "SELECT pricePerPerson FROM Tours WHERE tourID = ?";
        try (Connection conn = getConnection();
             PreparedStatement priceStmt = conn.prepareStatement(getPriceSQL)) {
            priceStmt.setInt(1, tourID);
            ResultSet rs = priceStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("pricePerPerson");
            } else {
                System.out.println("Tour not found");
                return 0; // or throw an exception
            }
        } catch (SQLException e) {
            System.out.println("Failed to get price: " + e.getMessage());
            return 0; // or throw an exception
        }
    }

    public void addBooking(Booking booking)  {
        String insertSQL = "INSERT INTO Bookings (customer, tourID, bookingDate, bookingTime, numSpots, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setInt(1, booking.getCustomer().getKennitala());
            pstmt.setInt(2, booking.getTourID());
            pstmt.setDate(3, booking.getBookingDate());
            pstmt.setTime(4, booking.getBookingTime());
            pstmt.setInt(5, booking.getNumSpots());
            pstmt.setInt(6, getPricePerPerson(booking.getTourID()));
            pstmt.executeUpdate();
            System.out.println("Booking successful");
        } catch (SQLException e) {
            System.out.println("Failed to add booking: " + e.getMessage());
        }
    }


    public void removeBooking(int bookingID) throws SQLException {
        String removeSQL = "DELETE FROM Bookings WHERE bookingID = ?";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(removeSQL)) {
            pstmt.setInt(1, bookingID);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 1) {
                System.out.println("Booking successfully cancelled.");
            } else if (affectedRows == 0) {
                System.out.println("No booking found with ID: " + bookingID);
            } else {
                System.out.println("Only one booking can be cancelled at a time " + affectedRows);
            }
        } catch (SQLException e) {
            System.out.println("Error removing booking: " + e.getMessage());
        }
    }


    public void update (Booking booking){

    }

}