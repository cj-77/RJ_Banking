package login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Transaction_History {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/bank";
    private String username = "root";
    private String dbPassword = "cj007";
    boolean a=false;

    public List<Transaction> getTransactionHistory(String userId) {
        List<Transaction> transactions = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, dbPassword);
            System.out.println("Connected to the MySQL database");

            // Prepare the SQL statement for the stored procedure
            String sql = "{call transactionH(?)}";
            preparedStatement = connection.prepareStatement(sql);

            // Set the input parameter for the stored procedure
            preparedStatement.setString(1, userId);

            // Execute the stored procedure
            resultSet = preparedStatement.executeQuery();

            // Process the result set and populate the list of transactions
            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                
                transaction.setUserId(resultSet.getString("id"));
                transaction.setAmount(resultSet.getFloat("Amount"));
                transaction.setLasrTransac(resultSet.getString("lasr_transac"));
                transaction.setLasrTransaction(resultSet.getFloat("lasr_transaction"));
                transaction.setLastTransaction(resultSet.getString("last_transaction"));
                transactions.add(transaction);

                // Debug: Print transaction details
                System.out.println(transaction);
                a=true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing resources in the finally block
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return transactions;
    }
}
