package MainAccount;

import java.sql.*;

public class OracleConnect {

    public static void insertCustomer(String name, String address, String phonenum) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded successfully!");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "fatima08");
            System.out.println("Connection established successfully!");

            try {
                // Insert the customer information into the Oracle database
                String sql = "INSERT INTO Customers (name, address, phonenum) VALUES (?,?,?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, address);
                statement.setString(3, phonenum);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Successfully inserted");
                }

                statement.close();
            } catch (SQLException e) {
                System.out.println("Error executing SQL query: " + e.getMessage());
            }

            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not loaded!");
        } catch (SQLException e) {
            System.out.println("Connection not established!");
        }
    }
}