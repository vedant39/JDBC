import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class BatchProcessing {
    // Database Connection Details
    private static final String url = "jdbc:mysql://localhost:3306/MyDB";
    private static final String username = "root";
    private static final String password = "Otaku_4639";

    public static void main(String[] args) {
        // Load Database Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection Successful");

            // Create a Scanner for user input
            Scanner scanner = new Scanner(System.in);

            String sql = "INSERT INTO Employees (first_name, last_name, email, phone_number, hire_date, job_title, salary) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Add multiple entries
                for (int i = 0; i < 3; i++) { // Assuming batch size of 3 for demonstration
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Enter hire date (yyyy-mm-dd): ");
                    Date hireDate = Date.valueOf(scanner.nextLine()); // Ensure format is correct

                    System.out.print("Enter job title: ");
                    String jobTitle = scanner.nextLine();

                    System.out.print("Enter salary: ");
                    BigDecimal salary = new BigDecimal(scanner.nextLine());

                    System.out.println("Enter more employees? (Y/N)");
                    String moreEmployees = scanner.next();

                    if (moreEmployees.equalsIgnoreCase("N")) {
                        break;
                    }

                    preparedStatement.setString(1, firstName);
                    preparedStatement.setString(2, lastName);
                    preparedStatement.setString(3, email);
                    preparedStatement.setString(4, phoneNumber);
                    preparedStatement.setDate(5, hireDate);
                    preparedStatement.setString(6, jobTitle);
                    preparedStatement.setBigDecimal(7, salary);

                    preparedStatement.addBatch();
                }

                // Execute batch
                preparedStatement.executeBatch();
                System.out.println("Batch processing complete.");
            }

        } catch (SQLException e) {
            // Handle SQL Exceptions
            System.out.println(e.getMessage());
        }
    }
}