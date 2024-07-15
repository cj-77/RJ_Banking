package login;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/withdraw-amount")
public class Withdrow  extends HttpServlet{

	    private static final long serialVersionUID = 1L;

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        // Retrieve username from session
	        HttpSession session = req.getSession(false);
	        if (session == null || session.getAttribute("username") == null) {
	            System.out.println("No session or username found. Redirecting to login page.---"+session);
	            resp.sendRedirect("login.jsp");
	            return;
	        }

	        String user_Id = (String) session.getAttribute("userId");

	        String withdraw = req.getParameter("amount");
	        Transactionn wb = new Transactionn();

	        System.out.println("Username from session: " + user_Id);

	        try {
	            // Attempt to parse the amount to float
	            float amountToWithdraw = Float.parseFloat(withdraw.trim());
	            
	            System.out.println("Amount to withdraw: " + amountToWithdraw);
	            wb.User_withdraw(amountToWithdraw, user_Id);
	            
	            if (wb.b) {
	            	
	            	  session = req.getSession();
	                 session.setAttribute("currentBalance", wb.Remaining_amount);
	                 
	                 resp.sendRedirect("user_Balance.jsp");
					
				}else {
					req.setAttribute("errorMessage", "Insufficient funds.");
					RequestDispatcher dispatcher = req.getRequestDispatcher("transaction.jsp");
		            dispatcher.forward(req, resp);
				}
	            
	        } catch (NumberFormatException e) {
	            System.out.println("Parameter 'amount' is not a valid float.");
	           
	            return;
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}

