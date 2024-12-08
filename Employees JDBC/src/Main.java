import java.sql.*;

public class Main {

    // Database connection details
    private static final String url = "jdbc:mysql://127.0.0.1:3306/TestDB"; // Database URL
    private static final String username = "root"; // Database username
    private static final String password = "Otaku_4639"; // Database password

    public static void main(String[] args) {
        // Step 1: Load the MySQL JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage()); // Print error if driver not found
        }

        // Step 2: Establish a connection to the database
        try {
            Connection connection = DriverManager.getConnection(url, username, password); // Connect to MySQL database
            Statement statement = connection.createStatement(); // Create a statement object for executing queries
            System.out.println("Connection successful"); // Confirm successful connection

            // Step 3: Execute a SELECT query to fetch all records from the 'employees' table
            String query = "SELECT * FROM employees"; // SQL query to retrieve all employee records
            ResultSet resultSet = statement.executeQuery(query); // Execute the query and store the result

            // Step 4: Iterate over the ResultSet to process each employee record
            while (resultSet.next()) {
                // Retrieve data for each employee
                int id = resultSet.getInt("id"); // Employee ID
                String firstName = resultSet.getString("first_name"); // First name
                String lastName = resultSet.getString("last_name"); // Last name
                String email = resultSet.getString("email"); // Email
                String phoneNumber = resultSet.getString("phone_number"); // Phone number
                java.sql.Date hireDate = resultSet.getDate("hire_date"); // Hire date
                String jobTitle = resultSet.getString("job_title"); // Job title
                java.math.BigDecimal salary = resultSet.getBigDecimal("salary"); // Salary

                // Step 5: Print the employee details to the console
                System.out.println("ID: " + id);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Email: " + email);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Hire Date: " + hireDate);
                System.out.println("Job Title: " + jobTitle);
                System.out.println("Salary: " + salary);

            }

        } catch (SQLException e) {
            // Step 6: Handle SQL exceptions
            System.out.println(e.getMessage()); // Print error message if a SQL exception occurs
        }
    }
}
