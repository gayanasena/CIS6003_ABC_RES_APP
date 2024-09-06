package com.icbt.gayana.cis6003_abc.Servlet;

import com.icbt.gayana.cis6003_abc.DAO.UserDAO;
import com.icbt.gayana.cis6003_abc.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDAO userDAO;

    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create or update user
        int userId = Integer.parseInt(request.getParameter("userId")); // Use 0 for new user
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role"); // e.g., "Admin", "Staff"
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String full_name = request.getParameter("full_name");

        User user = new User(userId, username,email, password, full_name, phone, role);
        boolean isSaved;

        if (userId > 0) {
            isSaved = userDAO.updateUser(user); // Update existing user
        } else {
            isSaved = userDAO.registerUser(user); // Add new user
        }

        if (isSaved) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user by ID
        int userId = Integer.parseInt(request.getParameter("userId"));

        User user = userDAO.getUserById(userId);

        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("userDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}

