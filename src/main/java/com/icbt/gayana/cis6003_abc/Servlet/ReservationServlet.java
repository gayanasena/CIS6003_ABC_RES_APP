package com.icbt.gayana.cis6003_abc.Servlet;

import com.icbt.gayana.cis6003_abc.DAO.ReservationDAO;
import com.icbt.gayana.cis6003_abc.Model.Reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/reservation-Servlet")
public class ReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create or update reservation
        int reservationId = Integer.parseInt(request.getParameter("reservationId")); // Use 0 for new reservation
        int userId = Integer.parseInt(request.getParameter("userId"));
        LocalDateTime reservationDate = LocalDateTime.parse(request.getParameter("reservationDate")); // Assumes proper format
        String reservationType = request.getParameter("reservationType"); // e.g., "Dine-In", "Delivery"

        ReservationDAO reservationDAO = new ReservationDAO();

        Reservation reservation = new Reservation();
        reservation.setReservationId(reservationId);
        reservation.setUserId(userId);
        reservation.setReservationType(reservationType);
        reservation.setDateTime(reservationDate);

        boolean isSaved;

        if (reservationId > 0) {
            isSaved = reservationDAO.updateReservation(reservation); // Update existing reservation
        } else {
            isSaved = reservationDAO.addReservation(reservation); // Add new reservation
        }

        if (isSaved) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
        // Call DAO to persist reservation
        reservationDAO.addReservation(reservation);
        response.sendRedirect("reservationSuccess.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReservationDAO reservationDAO = new ReservationDAO();
        // Retrieve reservation by ID
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));

        Reservation reservation = reservationDAO.getReservationById(reservationId);

        if (reservation != null) {
            request.setAttribute("reservation", reservation);
            request.getRequestDispatcher("reservationDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
