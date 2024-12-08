import java.sql.*;
public class Students {
    // Database connection details
    private static final String url = "jdbc:mysql://localhost:3306/MyDB"; // URL of the database
    private static final String username = "root"; // MySQL username
    private static final String password = "Otaku_4639"; // MySQL password

    public static void main(String[] args) {
        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // If the driver class is not found, print an error message
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }

        // Establish a connection to the database
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println("Connection Successful");

            // SQL query for inserting multiple values into the `students` table
            String query = String.format("UPDATE students SET phone_number = '%s' WHERE id = 1", "8605646904");

            // "INSERT INTO students (name, email, phone_number) VALUES ('%s', '%s', '%s')",
            //                    "Vedant", "vedantrajankar46@gmail.com", "7875405928"

            // Uncomment this block to create the `students` table
            // String query = "CREATE TABLE students (" +
            //                "id INT PRIMARY KEY AUTO_INCREMENT, " +
            //                "name VARCHAR(255), " +
            //                "email VARCHAR(255), " +
            //                "phone_number VARCHAR(255))";
            // statement.executeUpdate(query);
            // System.out.println("Table Created Successfully");

            // Execute the SQL query for insertion
            int rowsAffected = statement.executeUpdate(query);

            // Check if data was inserted successfully
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("Data not inserted");
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
