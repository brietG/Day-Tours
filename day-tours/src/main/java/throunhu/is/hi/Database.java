package throunhu.is.hi;
import java.sql.*;


public class Database {

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

    private void closeConnection(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }






    /* 
    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DB_URL = "jdbc:sqlite:resources/DayTours.db";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            
            /* 
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Tours";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                int price = rs.getInt("price");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Location: " + location);
                System.out.println("Price: " + price);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
            

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(conn);
    }
}
*/


}