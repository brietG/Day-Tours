package throunhu.is.hi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourDatabase {
    private static final String SELECT_BY_TYPE_QUERY = "SELECT * FROM Tours WHERE type = ? AND availableSpace > 0";
    private static final String DECREMENT_AVAILABLE_SPACE_QUERY = "UPDATE Tours SET availableSpace = availableSpace - ? WHERE tourID = ?";

    public Tour[] searchTours(String query) {
        String SEARCH_QUERY = "SELECT * FROM tours WHERE type LIKE ? OR location LIKE ? OR DATE_FORMAT(date, '%Y-%m-%d') LIKE ?";
    
        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SEARCH_QUERY)) {
    
            stmt.setString(1, "%" + query + "%");
            stmt.setString(2, "%" + query + "%");
            stmt.setString(3, "%" + query + "%");
    
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
            String name = rs.getString("name");
            String type = rs.getString("type");
            String location = rs.getString("location");
            int pricePerPerson = rs.getInt("pricePerPerson");
            Date tourDate = rs.getDate("tourDate");
            String tourTime = rs.getString("tourTime");
            int limitSpots = rs.getInt("limitSpots");
            boolean spaceAvailable = rs.getBoolean("spaceAvailable");
            Tour tour = new Tour(tourID, name, location, pricePerPerson, type, tourDate, tourTime, limitSpots, spaceAvailable);
            tours.add(tour);
        }
        return tours.toArray(new Tour[0]);
    }

    public void decrementAvailableSpace(int tourID, int numSpotsBooked) {
        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(DECREMENT_AVAILABLE_SPACE_QUERY)) {
            stmt.setInt(1, numSpotsBooked);
            stmt.setInt(2, tourID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTour(Tour tour) {
        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Tours (name, location, pricePerPerson, type, tourDate, tourTime, limitSpots, spaceAvailable) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, tour.getName());
            stmt.setString(2, tour.getLocation());
            stmt.setInt(3, tour.getPricePerPerson());
            stmt.setString(4, tour.getType());
            stmt.setDate(5, tour.getTourDate());
            stmt.setString(6, tour.getTourTime());
            stmt.setInt(7, tour.getLimitSpots());
            stmt.setBoolean(8, tour.getSpaceAvailable());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Tour extractTourFromResultSet(ResultSet rs) throws SQLException {
        int tourID = rs.getInt("tourID");
        String name = rs.getString("name");
        String type = rs.getString("type");
        String location = rs.getString("location");
        int pricePerPerson = rs.getInt("pricePerPerson");
        Date tourDate = rs.getDate("tourDate");
        String tourTime = rs.getString("tourTime");
        int limitSpots = rs.getInt("limitSpots");
        boolean spaceAvailable = rs.getBoolean("spaceAvailable");
        return new Tour(tourID, name, location, pricePerPerson, type, tourDate, tourTime, limitSpots, spaceAvailable);
    }

    public Tour getTourByDetails(String detail) {
        String GET_TOUR_QUERY = "SELECT * FROM tours WHERE id = ? OR location = ? OR name = ? OR type = ? OR date = ?";

        try (Connection conn = Database.getConnection();
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

    public List<Tour> getAllTours() {
        String GET_ALL_TOURS_QUERY = "SELECT * FROM tours";
    
        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET_ALL_TOURS_QUERY);
            ResultSet rs = stmt.executeQuery()) {
    
            List<Tour> tours = new ArrayList<>();
            while (rs.next()) {
                tours.add(extractTourFromResultSet(rs));
            }
            return tours;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
