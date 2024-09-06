package com.icbt.gayana.cis6003_abc.Servlet;

import com.icbt.gayana.cis6003_abc.DAO.UserDAO;
import com.icbt.gayana.cis6003_abc.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get login parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the user credentials using UserDAO
        User user = userDAO.login(username, password);

        if (user != null) {
            // Create a session for the user
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Redirect to different pages based on user role
            switch (user.getRole().toLowerCase()) {
                case "admin":
                    response.sendRedirect("adminDashboard.jsp");
                    break;
                case "staff":
                    response.sendRedirect("staffDashboard.jsp");
                    break;
                case "client":
                    response.sendRedirect("/client");
                    break;
                default:
                    // Default to login page if role is unknown
                    session.invalidate();
                    response.sendRedirect("dashboard.jsp?error=UnknownRole");
                    break;
            }
        } else {
            // Invalid login, redirect to login page with error
            response.sendRedirect("dashboard.jsp?error=InvalidCredentials");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);

    }
}
