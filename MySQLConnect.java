package MainAccount;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MySQLConnect {

    public static void insertCustomer(String name, String address, String phonenum) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hello", "root", "fatima08");
            
            // Insert the customer information into the MySQL database
            String insertSql = "INSERT INTO Customers (name, address, phonenum) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = con.prepareStatement(insertSql);
            insertStatement.setString(1, name);
            insertStatement.setString(2, address);
            insertStatement.setString(3, phonenum);

            int rowsInserted = insertStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Successfully inserted into MySQL database");
                
                // Display the inserted customer's information
                System.out.println("Inserted Customer Information:");
                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Phone Number: " + phonenum);
            }

            insertStatement.close();

            // Close the connection
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}