package login;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class Transactionn {
	float Remaining_amount;
	boolean b=false;
	
	 String jdbcUrl = "jdbc:mysql://localhost:3306/bank";
     String username1 = "root";
     String password1 = "cj007";

     Connection connection = null;
     CallableStatement statement=null;
     ResultSet resultSet = null;
    public void User_withdraw(float Blance,String usid) throws ClassNotFoundException {
           
        // Database connection parameters
        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing the connection
            connection = DriverManager.getConnection(jdbcUrl, username1, password1);
            System.out.println(" balance check Connected to the MySQL database");
     
            String userId = usid; // Replace with actual user ID
            float bal = Blance; // Replace with actual balance

            // Call the stored procedure
            String sql = "{CALL Withdraw_Amount(?, ?)}";
            statement = connection.prepareCall(sql);

            // Set input parameters
            statement.setString(1, userId);
            statement.setFloat(2, bal);
             System.out.println(userId);
            // Execute the stored procedure
             resultSet = statement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                float remainingBalance = resultSet.getFloat("Amount");
                System.out.println("Remaining Balance: " + remainingBalance);
                Remaining_amount=remainingBalance;b=true;
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void User_Deposit(float Blance,String usid) throws ClassNotFoundException {

        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing the connection
            connection = DriverManager.getConnection(jdbcUrl, username1, password1);
            System.out.println(" balance check Connected to the MySQL database");
     
            String userId = usid; // Replace with actual user ID
            float bal = Blance; // Replace with actual balance

            // Call the stored procedure
            String sql = "{CALL Deposit_Amount(?, ?)}";//transactionH
            statement = connection.prepareCall(sql);
            System.out.println("Username from session: " + userId+"   "+bal);
            // Set input parameters
            statement.setString(1, userId);
            statement.setFloat(2, bal);
             System.out.println(userId);
            // Execute the stored procedure
             resultSet = statement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                float remainingBalance = resultSet.getFloat("Amount");
                System.out.println("Balance: " + remainingBalance);
                Remaining_amount=remainingBalance;b=true;
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void User_Tr(String usid) throws ClassNotFoundException {

        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing the connection
            connection = DriverManager.getConnection(jdbcUrl, username1, password1);
            System.out.println(" balance check Connected to the MySQL database");
     
            String userId = usid; // Replace with actual user ID
             // Replace with actual balance

            // Call the stored procedure
            String sql = "{CALL transactionH(?)}";//transactionH
            statement = connection.prepareCall(sql);

            // Set input parameters
            statement.setString(1, userId);
            
            // Execute the stored procedure
             resultSet = statement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                float remainingBalance = resultSet.getFloat("Amount");
                System.out.println("Balance: " + remainingBalance);
                Remaining_amount=remainingBalance;b=true;
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }