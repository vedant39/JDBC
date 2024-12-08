import java.sql.*;
public class Employees {
    // Database Conection Details
    private static final String url = "jdbc:mysql://localhost:3306/MyDB";
    private static final String username = "root";
    private static final String password = "Otaku_4639";

    public static void main  (String[]args){
        // loading Database Driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //Establishing a connection

        try{
            Connection connection = DriverManager.getConnection(url,username,password);// Create a connection with the database
            Statement statement = connection.createStatement();//Create statement object to execute queries
            System.out.println("Connection Successful ");

            //Executing the queries to fetch data from the table Employees
            String query = "SELECT * FROM Employees";//SQl Query to retrieve data from the table employees
            ResultSet resultSet = statement.executeQuery(query);

            //Iterate over the ResultSet to process each employee record
            while(resultSet.next()){

                int id = resultSet.getInt("id"); // Employee ID
                String firstName = resultSet.getString("first_name"); // First name
                String lastName = resultSet.getString("last_name"); // Last name
                String email = resultSet.getString("email"); // Email
                String phoneNumber = resultSet.getString("phone_number"); // Phone number
                java.sql.Date hireDate = resultSet.getDate("hire_date"); // Hire date
                String jobTitle = resultSet.getString("job_title"); // Job title
                java.math.BigDecimal salary = resultSet.getBigDecimal("salary"); // Salary

                // Print the Employee Details to the console
                System.out.println("ID: "+id+"\n " +
                        "First Name: "+firstName+"\n " +
                        "Last Name: "+lastName+"\n " +
                        "Email: "+email+"\n " +
                        "Phone Number: "+phoneNumber+"\n " +
                        "Job Title: "+jobTitle+"\n " +
                        "Hire Date: "+ hireDate +"\n " +
                        "Salary: "+salary + "\n" + "---------------------------------------");
            }
        }catch(SQLException e ){
            // Handle the SQL Exceptions
            System.out.println(e.getMessage()); // Print Error Message If SQL exception occurs
        }
    }
}
