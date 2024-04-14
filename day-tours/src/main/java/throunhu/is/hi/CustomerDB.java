package throunhu.is.hi;

import java.net.URL;
import java.sql.*;

public class CustomerDB {
    private Connection getConnection()  {
        URL res = getClass().getClassLoader().getResource("DayTours.db");
        if (res == null) {
            throw new RuntimeException("Database file not found");
        }
        String url = "jdbc:sqlite:" + res.getPath();
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
            throw new RuntimeException("Cannot connect to the database", e);
        }
        return conn;
    }

    private void closeConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close();
            }
            catch(SQLException e) {
                System.err.println(e);
            }

    }




    /*
    private Database cdb;

    public CustomerDB(Database cdb) {
        this.cdb = cdb;
    }

*/


    public void addCustomer(Customer customer) {
         String insert = "INSERT INTO Customer (kennitala, name, email, phone) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insert)) {

            // Set values for the placeholders in the SQL statement
            pstmt.setInt(1, customer.getKennitala());
            pstmt.setString(2, customer.getName());
            pstmt.setString(3, customer.getEmail());
            pstmt.setInt(4, customer.getPhone());

            // Execute the SQL statement
            pstmt.executeUpdate();
            System.out.println("Customer added successfully.");

        } catch (SQLException e) {
            // Handle connection or SQL exceptions
            System.err.println("Error adding customer" + e.getMessage()); // For demonstration purposes, handle more gracefully in production
        }

        }

    }



