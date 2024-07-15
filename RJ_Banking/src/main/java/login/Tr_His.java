package login;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/transactionHistory")
public class Tr_His extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve userId from request parameters
    	DATA_LOGIN dl = new DATA_LOGIN();
        HttpSession session = request.getSession(false);
        String userId =(String) session.getAttribute("userId");

        if (userId == null || userId.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing user ID");
            return;
        }

        // Fetch transactions using the Transaction_History class
        Transaction_History transactionHistory = new Transaction_History();
        List<Transaction> transactions = transactionHistory.getTransactionHistory(userId);

        // Debug: Print the size of the transactions list
        System.out.println("Number of transactions retrieved: " + transactions.size());

        // Set transactions as a request attribute
        request.setAttribute("transactions", transactions);

        // Forward to the JSP
        request.getRequestDispatcher("/transactionDetails.jsp").forward(request, response);
    }

    // Handle POST requests by redirecting them to doGet method
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
