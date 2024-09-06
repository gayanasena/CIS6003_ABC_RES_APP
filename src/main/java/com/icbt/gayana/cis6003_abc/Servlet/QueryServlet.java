package com.icbt.gayana.cis6003_abc.Servlet;

import com.icbt.gayana.cis6003_abc.DAO.QueryDAO;
import com.icbt.gayana.cis6003_abc.DAO.UserDAO;
import com.icbt.gayana.cis6003_abc.Model.Query;
import com.icbt.gayana.cis6003_abc.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {

    private QueryDAO queryDAO;

    @Override
    public void init() throws ServletException {
        queryDAO = new QueryDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a new query
        int userId = Integer.parseInt(request.getParameter("userId"));
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        LocalDateTime createdAt = LocalDateTime.now();

        UserDAO userDAO = new UserDAO();

        User user = userDAO.getUserById(userId);

        Query query = new Query();

        query.setQueryId(0);
        query.setUser(user);
        query.setSubject(subject);
        query.setMessage(message);
        query.setStatus("Pending");
        query.setResponse("");
        query.setCreatedAt(createdAt);

        boolean isAdded = queryDAO.addQuery(query);

        if (isAdded) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve query by ID
        int queryId = Integer.parseInt(request.getParameter("queryId"));
        Query query = queryDAO.getQueryById(queryId);

        if (query != null) {
            request.setAttribute("query", query);
            request.getRequestDispatcher("queryDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}

