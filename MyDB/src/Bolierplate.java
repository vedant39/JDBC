import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bolierplate {
     // Dtabase Connection details
    private static final String url = "";
    private static final String username = "root";
    private static final String password = "Otaku_4639";
    public static void main(String[] args) {
        //Load the drivers
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        // ESTABLISHING A CONNECTION
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            System.out.println("Connection Successful");

            // Executing your Specific Query
            String query = "//Your Specific Query frm SQL" ;
            ResultSet  result = statement.executeQuery/*executeUpdate is used to update teh database Query */(query);// Execute Query and Store Value

           /* while(result.next()){}// this is used to iterate through all the database rows */

        }catch(SQLException e){

            System.out.println(e.getMessage());

        }

    }
}