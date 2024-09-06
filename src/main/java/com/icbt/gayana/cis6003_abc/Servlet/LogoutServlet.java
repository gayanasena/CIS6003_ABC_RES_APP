package com.icbt.gayana.cis6003_abc.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session and redirect to login page
        HttpSession session = request.getSession(false); // False ensures it doesn't create a new session if none exists
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("Home.jsp");
    }
}

