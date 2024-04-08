package throunhu.is.hi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourController {
    private static final String SEARCH_BY_TYPE_QUERY = "SELECT * FROM Tours WHERE type = ?";
    private static final String SEARCH_BY_LOCATION_QUERY = "SELECT * FROM Tours WHERE location = ?";
    private static final String SEARCH_BY_DATE_QUERY = "SELECT * FROM Tours WHERE tourDate = ?";
    private static final String SELECT_BY_TYPE_QUERY = "SELECT * FROM Tours WHERE type = ?";

    public Tour[] searchTourByType(String type) {
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SEARCH_BY_TYPE_QUERY)) {
            stmt.setString(1, type);
            try (ResultSet rs = stmt.executeQuery()) {
                return extractToursFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Tour[] searchTourByLocation(String location) {
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SEARCH_BY_LOCATION_QUERY)) {
            stmt.setString(1, location);
            try (ResultSet rs = stmt.executeQuery()) {
                return extractToursFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Tour[] searchTourByDate(Date date) {
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SEARCH_BY_DATE_QUERY)) {
            stmt.setDate(1, date);
            try (ResultSet rs = stmt.executeQuery()) {
                return extractToursFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Tour[] selectTourByType(String type) {
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_TYPE_QUERY)) {
            stmt.setString(1, type);
            try (ResultSet rs = stmt.executeQuery()) {
                return extractToursFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Tour[] extractToursFromResultSet(ResultSet rs) throws SQLException {
        List<Tour> tours = new ArrayList<>();
        while (rs.next()) {
            int tourID = rs.getInt("tourID");
            String type = rs.getString("type");
            String location = rs.getString("location");
            int pricePerPerson = rs.getInt("pricePerPerson");
            Date tourDate = rs.getDate("tourDate");
            String tourTime = rs.getString("tourTime");
            boolean spaceAvailable = rs.getBoolean("spaceAvailable");
            Tour tour = new Tour(tourID, location, pricePerPerson, type, tourDate, tourTime, spaceAvailable);
            tours.add(tour);
        }
        return tours.toArray(new Tour[0]);
    }
}
