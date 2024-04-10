package throunhu.is.hi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDatabase {

    public void addBookingToDatabase(Booking booking) throws SQLException {
        // This method would interact with your BookingDatabase class
        String insertSQL = "INSERT INTO Bookings (customerID, tourID, bookingDate, bookingTime, numSpots, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setInt(1, booking.getCustomer().getKennitala());
            pstmt.setInt(2, booking.getTourID());
            pstmt.setDate(3, Date.valueOf(booking.getBookingDate()));
            pstmt.setTime(4, Time.valueOf(booking.getBookingTime()));
            pstmt.setInt(5, booking.getNumSpots());
            pstmt.setInt(6, booking.getPrice());
            pstmt.executeUpdate();
        }
    
    public void update(Booking booking) { 

    }
    public void remove(Booking booking) { 
        
    }
}