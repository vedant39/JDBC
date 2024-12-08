import java.sql.*;

public class UpdatePreparedStudent {

    private static final String url = "jdbc:mysql://localhost:3306/MyDB";
    private static final String username = "root";
    private static final String password = "Otaku_4639";

    public static void main(String[] args){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            try{
                Connection connection = DriverManager.getConnection(url,username,password);
                String query = "UPDATE students SET email = ? WHERE id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1,"vedantrajankar48@gmail.com");
                preparedStatement.setInt(2,1);
                
                int rowsUpdated = preparedStatement.executeUpdate();
                
                if(rowsUpdated > 0){
                    System.out.println("Data Updated Successfully");
                }else{
                    System.out.println("Data Not Updated");
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}
