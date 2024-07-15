package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DATA_LOGIN{

    boolean a;
    String userId;
    String userName;
    int age;
    long phoneNumber;
    float amount;
    String jdbcUrl = "jdbc:mysql://localhost:3306/bank";
    String username = "root";
    String dbPassword = "cj007";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public void logind(String userid, String password) {
        // Database connection parameters
        

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing the connection
            connection = DriverManager.getConnection(jdbcUrl, username, dbPassword);
            System.out.println("Connected to the MySQL database");

            // Prepare the call statement for the stored procedure
            String sql = "{call GetUserById(?, ?)}";
            preparedStatement = connection.prepareStatement(sql);

            // Set the input parameters for the stored procedure
            preparedStatement.setString(1, userid);
            preparedStatement.setLong(2, Long.parseLong(password)); // Assuming password is a BIGINT

            // Execute the stored procedure
            resultSet = preparedStatement.executeQuery();

            // Process the result set if needed
            while (resultSet.next()) {
                userId = resultSet.getString("user_id");
                userName = resultSet.getString("user_name");
                age = resultSet.getInt("age");
                phoneNumber = resultSet.getLong("Phone");
                amount = resultSet.getFloat("Amount");
                a = true;
                // Print or process retrieved data
                System.out.println("User ID: " + userId);
                System.out.println("Username: " + userName);
                System.out.println("Age: " + age);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Amount: " + amount);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing resources in finally block
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void Sinup(String userid, String password, String Repassword,String name,int Age ,long PhoneNumber,float Amount) {
        // Database connection parameters
        

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing the connection
            connection = DriverManager.getConnection(jdbcUrl, username, dbPassword);
            System.out.println("Connected to the MySQL database");

            // Prepare the call statement for the stored procedure
            String sql = "{call Sinup(?,?,?,?,?,?,?)}";
            //call Sinup("user666",123,123,"jaga",21,9182336252,1000.50)
            preparedStatement = connection.prepareStatement(sql);

            // Set the input parameters for the stored procedure
            preparedStatement.setString(1, userid);
            preparedStatement.setLong(2, Long.parseLong(password)); // Assuming password is a BIGINT
            preparedStatement.setLong(3, Long.parseLong(Repassword));
            preparedStatement.setString(4, name);
            preparedStatement.setInt(5, Age);
            preparedStatement.setLong(6, PhoneNumber);
            preparedStatement.setFloat(7, Amount);

            // Execute the stored procedure
            resultSet = preparedStatement.executeQuery();

            // Process the result set if needed
            while (resultSet.next()) {
            	 userId = resultSet.getString("user_id");
                 userName = resultSet.getString("user_name");
                 age = resultSet.getInt("age");
                 phoneNumber = resultSet.getLong("Phone");
                 amount = resultSet.getFloat("Amount");
                 a = true;
                // Print or process retrieved data
                System.out.println("User ID: " + userId);
                System.out.println("Username: " + userName);
                System.out.println("Age: " + age);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Amount: " + amount);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing resources in finally block
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
