package throunhu.is.hi;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TourDatabase{
    private static final String SELECT_BY_TYPE_QUERY = "SELECT * FROM Tours WHERE type = ? AND availableSpace > 0";
    private static final String DECREMENT_AVAILABLE_SPACE_QUERY = "UPDATE Tours SET availableSpace = availableSpace - ? WHERE tourID = ?";
    private final Database db;

    public TourDatabase(Database db) {
        this.db = db;
    }

    public List<Tour> searchTours(String query) {
        String SEARCH_QUERY = "SELECT * FROM Tours WHERE type LIKE ? OR location LIKE ? OR strftime('%Y-%m-%d', tourDate) LIKE ?";
        try (Connection conn = db.getConnection();
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

    public List<Tour> selectTourByType(String type) {
        try (Connection conn = db.getConnection();
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

    private Tour extractTourFromResultSet(ResultSet rs) throws SQLException {
        int tourID = rs.getInt("tourID");
        String name = rs.getString("name");
        String type = rs.getString("type");
        String location = rs.getString("location");
        int pricePerPerson = rs.getInt("pricePerPerson");

        // Parse the date using LocalDate
        String dateStr = rs.getString("tourDate");
        LocalDate tourDate = null;
        if (dateStr != null) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            tourDate = LocalDate.parse(dateStr, dateFormatter);
        }

        // Parse the time using LocalTime
        String timeStr = rs.getString("tourTime");
        LocalTime tourTime = null;
        if (timeStr != null) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            tourTime = LocalTime.parse(timeStr, timeFormatter);
        }

        int limitSpots = rs.getInt("limitSpots");
        boolean spaceAvailable = rs.getBoolean("spaceAvailable");

        return new Tour(tourID, name,location,pricePerPerson,type,tourDate,tourTime,limitSpots,spaceAvailable);
    }


    private List<Tour> extractToursFromResultSet(ResultSet rs) throws SQLException {
        List<Tour> tours = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (rs.next()) {
            int tourID = rs.getInt("tourID");
            String name = rs.getString("name");
            String type = rs.getString("type");
            String location = rs.getString("location");
            int pricePerPerson = rs.getInt("pricePerPerson");

            String dateStr = rs.getString("tourDate");
            LocalDate tourDate = (dateStr != null) ? LocalDate.parse(dateStr, dateFormatter) : null;

            String timeStr = rs.getString("tourTime");
            LocalTime tourTime = (timeStr != null) ? LocalTime.parse(timeStr, timeFormatter) : null;

            int limitSpots = rs.getInt("limitSpots");
            boolean spaceAvailable = rs.getBoolean("spaceAvailable");

            // Ensure your Tour constructor now accepts LocalDate and LocalTime instead of Date and Time
            Tour tour = new Tour(tourID,name,location,pricePerPerson,type,tourDate,tourTime,limitSpots,spaceAvailable);
            tours.add(tour);
        }
        return tours;
    }


    public void decrementAvailableSpace(int tourID, int numSpots) {
        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(DECREMENT_AVAILABLE_SPACE_QUERY)) {
            stmt.setInt(1, numSpots);
            stmt.setInt(2, tourID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

    }

    public void addTour(Tour tour) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Tours (name, location, pricePerPerson, type, tourDate, tourTime, limitSpots, spaceAvailable) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, tour.getName());
            stmt.setString(2, tour.getLocation());
            stmt.setInt(3, tour.getPricePerPerson());
            stmt.setString(4, tour.getType());

            // Convert LocalDate to sql.Date
            LocalDate localDate = tour.getTourDate();
            if (localDate != null) {
                Date tourDate = Date.valueOf(localDate);
                stmt.setDate(5, tourDate);
            } else {
                stmt.setNull(5, Types.DATE);
            }
            LocalTime localTime = tour.getTourTime();
            if (localTime != null) {
                Time tourTime = Time.valueOf(localTime);
                stmt.setTime(6, tourTime);
            } else {
                stmt.setNull(6, Types.TIME);
            }
            stmt.setInt(7, tour.getLimitSpots());
            stmt.setBoolean(8, tour.getSpaceAvailable());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tour> getTourByDetails(String detail) {
        String GET_TOUR_QUERY = "SELECT * FROM tours WHERE location = ? OR name = ? OR type = ? OR date = ?";
        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET_TOUR_QUERY)) {
            stmt.setString(1, detail);
            stmt.setString(2, detail);
            stmt.setString(3, detail);
            stmt.setString(4, detail);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractToursFromResultSet(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

private static final Logger logger = Logger.getLogger(TourDatabase.class.getName());
    public List<Tour> getAllTours() {
        String GET_ALL_TOURS_QUERY = "SELECT * FROM Tours";
        List<Tour> tours = new ArrayList<>();
        try (Connection conn = this.db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_ALL_TOURS_QUERY);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                tours.add(extractTourFromResultSet(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to retrieve tours", e);
            return new ArrayList<>(); // Return an empty list or handle differently
        }
        return tours;
    }


    public Tour getTourById(int tourID) {
        String query = "SELECT * FROM Tours WHERE tourID = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, tourID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractTourFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching tour: " + e.getMessage());
            return null;
        }
        return null;
    }

}