package throunhu.is.hi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourDatabase {
    private List<Tour> tours;

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

    private void closedConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public List <Tour> getAllTours() {
        String GET_ALL_TOURS_QUERY = "SELECT * FROM tours";

    try (Connection conn = connectionToDb();
        PreparedStatement stmt = conn.prepareStatement(GET_ALL_TOURS_QUERY);
        ResultSet rs = stmt.executeQuery()) {

        List<Tour> tours = new ArrayList<>();
        while (rs.next()) {
            tours.add(extractTourFromResultSet(rs));
        }
        return tours; // Changed from tours.toArray(new Tour[0]) to tours
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


    private Tour extractTourFromResultSet(ResultSet rs) throws SQLException {
        int tourID = rs.getInt("tourID");
        String name = rs.getString("name");
        String type = rs.getString("type");
        String location = rs.getString("location");
        int pricePerPerson = rs.getInt("pricePerPerson");
        Date tourDate = rs.getDate("tourDate");
        Time tourTime = rs.getTime("tourTime");
        int limitSpots = rs.getInt("limitSpots");
        boolean spaceAvailable = rs.getBoolean("spaceAvailable");
        return new Tour(tourID, name, location, pricePerPerson, type, tourDate, tourTime, limitSpots, spaceAvailable);
    }

    public List<Tour> searchTour(String query) {
        String SEARCH_QUERY = "SELECT * FROM tours WHERE name LIKE ? OR location LIKE ? OR type LIKE ? OR DATE_FORMAT(date, '%Y-%m-%d') LIKE ?";
    
        try (Connection conn = connectionToDb();
            PreparedStatement stmt = conn.prepareStatement(SEARCH_QUERY)) {
    
            stmt.setString(1, "%" + query + "%");
            stmt.setString(2, "%" + query + "%");
            stmt.setString(3, "%" + query + "%");
            stmt.setString(4, "%" + query + "%");
    
            try (ResultSet rs = stmt.executeQuery()) {
                List<Tour> tours = new ArrayList<>();
                while (rs.next()) {
                    tours.add(extractTourFromResultSet(rs));
                }
                return tours;
            }
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
            return null;
        }
    }
/* 
    public Tour [] selectTourByType(String type) throws SQLException {
        String SELECT_BY_TYPE_QUERY = "SELECT * FROM tours WHERE type = ? AND spaceAvailable = 1";

        try (Connection conn = connectionToDb();
            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_TYPE_QUERY)) {
            stmt.setString(1, type);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractTourFromResultSet(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

*/
    
    //private static final String SELECT_BY_TYPE_QUERY = "SELECT * FROM Tours WHERE type = ? AND availableSpace > 0";
    private static final String DECREMENT_AVAILABLE_SPACE_QUERY = "UPDATE Tours SET availableSpace = availableSpace - ? WHERE tourID = ?";


    public void decrementAvailableSpace(int tourID, int numSpotsBooked) {
        try (
            Connection conn = connectionToDb();
            PreparedStatement stmt = conn.prepareStatement(DECREMENT_AVAILABLE_SPACE_QUERY)) {
            stmt.setInt(1, numSpotsBooked);
            stmt.setInt(2, tourID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

    }

    public Tour getTourByDetails(String detail) {
        String GET_TOUR_QUERY = "SELECT * FROM tours WHERE id = ? OR location = ? OR name = ? OR type = ? OR date = ?";

        try (Connection conn = connectionToDb();
            PreparedStatement stmt = conn.prepareStatement(GET_TOUR_QUERY)) {

            stmt.setString(1, detail);
            stmt.setString(2, detail);
            stmt.setString(3, detail);
            stmt.setString(4, detail);
            stmt.setString(5, detail);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractTourFromResultSet(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}