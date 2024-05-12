package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;

@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public InscriptionServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String errorMessage = null;

        // Create AccountDAO instance
        AccountDAO accountDAO = new AccountDAO();

        try {
            // Try to add the user
            if (accountDAO.addUser(fullName, username, password)) {
                response.sendRedirect("index.jsp");
            } else {
                // User with the same username already exists
                errorMessage = "Username already exists";
                response.sendRedirect("inscription.jsp?error=" + errorMessage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}
