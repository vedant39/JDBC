import java.sql.*;
public class PreparedStudent {

    private static final String url = "jdbc:mysql://localhost:3306/MyDB";
    private static final String username = "root";
    private static final String password = "Otaku_4639";

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            try{
                Connection connection = DriverManager.getConnection(url,username,password);
                String query = "SELECT email FROM students WHERE id = ?";

                /*Statement statement = connection.createStatement(); for default statement */

                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setInt(1,1);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()){
                    String email = resultSet.getString("email");
                    System.out.println( "Email :" + email);
                }else {
                    System.out.println("No Data Found");
                }

               /*
                * preparedStatement.setString(1,"Ajay");
                * preparedStatement.setString(2,"adinsist26@gamil.com ");
                * preparedStatement.setString(3,"7875405928");

                * !   int rowsAffected = preparedStatement.executeUpdate();

                *if(rowsAffected > 0){
                *  System.out.println("Data inserted successfully");
                *}else {
                *  System.out.println("Data Not Inserted");
                *}

                 */

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
