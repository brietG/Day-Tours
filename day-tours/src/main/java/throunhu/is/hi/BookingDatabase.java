package throunhu.is.hi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDatabase {
     public List<Booking> select(String query) {
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Retrieve booking information from the ResultSet and create Booking objects
                int bookingID = rs.getInt("bookingID");
                // Retrieve other booking attributes similarly
                Booking booking = new Booking(bookingID, /* Other booking attributes */);
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
    
    public void update(Booking booking) { 

    }
    public void remove(Booking booking) { 
        
    }
}