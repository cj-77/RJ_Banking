package login;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Sigup")
public class SinUp extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("username");
        String user_password = request.getParameter("password");
        String ReEnterpassword = request.getParameter("ReEnterpassword");
        String name = request.getParameter("name");
        String Age = request.getParameter("Age");
        String PhoneNumber = request.getParameter("PhoneNumber");
        String Amount = request.getParameter("Amount");
        

        // Create an instance of DATA_LOGIN to perform the login check
        DATA_LOGIN dl = new DATA_LOGIN();
        int  userAge=Integer.parseInt(Age.trim());
        float amount = Float.parseFloat(Amount.trim());
        long Phone=Long.parseLong(PhoneNumber.trim());
        
        dl.Sinup(user_name, user_password,ReEnterpassword,name,userAge,Phone,amount);
        
        
        if (dl.a) {
            // Login successful - redirect to the main banking page (conform.html)
            System.out.println("Login successful, redirecting to conform.html");
            
            HttpSession session = request.getSession();
            session.setAttribute("userId",dl.userId);
            session.setAttribute("username",dl.userName);
            session.setAttribute("age", dl.age);
            session.setAttribute("phoneNumber", dl.phoneNumber);
            session.setAttribute("currentBalance", dl.amount);
            
            System.out.println("////////////////////////////"+dl.userId);
            
            response.sendRedirect("userDetails.jsp");
        } else {
            // Login failed - forward to the login page with an error message
            System.out.println("Sinup failed, redirecting to Signupjsp.jsp with error message");

            // Set an error message attribute to be displayed on the login page
            request.setAttribute("errorMessage", "Invalid username or password. Please try again.");

            // Forward back to the login.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("Signupjsp.jsp");
            dispatcher.forward(request, response);
        }
    }
}
