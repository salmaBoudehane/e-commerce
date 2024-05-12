package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String errorMessage = null;
        
        AccountDAO accountDAO = new AccountDAO();
        try {
            boolean isValidUser = accountDAO.validateUser(username, password);
            
            if (isValidUser) {
                // Create a session for the user
                HttpSession session = request.getSession();
                // Store the username in the session
                session.setAttribute("username", username);
                
                // Redirect to success page or perform other actions
                response.sendRedirect("success.jsp");
            } else {
            	errorMessage = "Invalid username or password";
                response.sendRedirect("login.jsp?error=" + errorMessage);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle database errors
            // Redirect to error page or display an error message
        }
	}

}
