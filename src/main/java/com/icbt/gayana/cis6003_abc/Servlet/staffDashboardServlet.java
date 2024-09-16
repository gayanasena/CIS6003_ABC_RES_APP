package com.icbt.gayana.cis6003_abc.Servlet;

import com.icbt.gayana.cis6003_abc.DAO.ReservationDAO;
import com.icbt.gayana.cis6003_abc.DAO.UserDAO;
import com.icbt.gayana.cis6003_abc.Model.Reservation;
import com.icbt.gayana.cis6003_abc.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/staff")
public class staffDashboardServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        ReservationDAO reservationDAO = new ReservationDAO();
        HttpSession httpSession = request.getSession();

        if(httpSession.getAttribute("user") == null) {
            response.sendRedirect("login");
        }else{
            User user = (User) httpSession.getAttribute("user");

            if(user != null) {
                int currentUserId = user.getUser_id();

                if(currentUserId > 0){
                    List<Reservation> reservations = reservationDAO.getAllReservations();

                    request.setAttribute("reservations", reservations);
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("staffDashboard.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("/login").forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

