package com.icbt.gayana.cis6003_abc.Servlet;

import com.icbt.gayana.cis6003_abc.DAO.ActionLogDAO;
import com.icbt.gayana.cis6003_abc.DAO.UserDAO;
import com.icbt.gayana.cis6003_abc.Model.ActionLog;
import com.icbt.gayana.cis6003_abc.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/actionLog")
public class ActionLogServlet extends HttpServlet {

    private ActionLogDAO actionLogDAO;

    @Override
    public void init() throws ServletException {
        actionLogDAO = new ActionLogDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a new action log
        int userId = Integer.parseInt(request.getParameter("userId"));
        String actionDescription = request.getParameter("actionDescription");
        LocalDateTime actionDate = LocalDateTime.now();

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(userId);

        ActionLog actionLog = new ActionLog(0, user, actionDescription, actionDate);

        boolean isAdded = actionLogDAO.addActionLog(actionLog);
        if (isAdded) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve action logs by user
        int userId = Integer.parseInt(request.getParameter("userId"));

        List<ActionLog> actionLog
                = actionLogDAO.getActionLogsByUser(userId);

        request.setAttribute("actionLogs", actionLog);
        request.getRequestDispatcher("actionLogList.jsp").forward(request, response);
    }
}

