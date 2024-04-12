package throunhu.is.hi;
import java.sql.*;


public class Database {
    /*
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc://localhost/DayTours";
    static final String USER = "hopur4";
    static final String PASS = "hopur4";


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL driver not found", e);
        }
    }*/

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


