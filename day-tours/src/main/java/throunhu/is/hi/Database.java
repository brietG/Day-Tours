package throunhu.is.hi;
import java.sql.*;


public class Database {
    private Connection conn;

    public Connection getConnection() {
        String url = "jdbc:sqlite:daytours.db";
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url);
                System.out.println("Connection to SQLite has been established.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database", e);
        }
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
        } catch (SQLException e) {
            // Log or handle the exception appropriately
            e.printStackTrace();
        }
    }
}

