package throunhu.is.hi;
import java.sql.*;


public class Database {

    public Connection conn;

    public Connection getConnection() {
        String url = "jdbc:sqlite:daytrip.db";
        try {
            if (conn == null || conn.isClosed()) {
                //Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(url);
                System.out.println("Connection to SQLite has been established.");
            }
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
            // It's often a good idea to re-throw the exception to allow higher-level methods to handle it appropriately.
            throw new RuntimeException("Cannot connect to the database", e);
        }
        return conn;
    }


}


