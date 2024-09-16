package com.icbt.gayana.cis6003_abc.Servlet;

import com.icbt.gayana.cis6003_abc.DAO.ReservationDAO;
import com.icbt.gayana.cis6003_abc.DAO.UserDAO;
import com.icbt.gayana.cis6003_abc.Model.Query;
import com.icbt.gayana.cis6003_abc.Model.Reservation;
import com.icbt.gayana.cis6003_abc.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create or update reservation
        int reservationId = 0;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        LocalDateTime reservationDate = LocalDateTime.parse(request.getParameter("reservationDate"));
        String reservationType = request.getParameter("reservationType");
        String reservationSubType = request.getParameter("reservationSubType");
        String clientMessage = request.getParameter("message");
        String guestCount = request.getParameter("guestCount");

//        find user
        UserDAO userDAO = new UserDAO();
        ReservationDAO reservationDAO = new ReservationDAO();
        Reservation reservation = new Reservation();

        User emailOwnerUser = userDAO.findUserByEmail(email);

        if(emailOwnerUser != null && emailOwnerUser.getEmail().equals(email)) {
            reservation.setReservationId(reservationId);
            reservation.setUserId(emailOwnerUser.getUser_id());
            reservation.setReservationType(reservationType);
            reservation.setDateTime(reservationDate);
            reservation.setSub_type(reservationSubType);
            reservation.setGuestCount(Integer.parseInt(guestCount));
            reservation.setStatus("Booked");
            reservation.setNotes("Name - "+name+" Email - "+email+" Phone - "+phone+" Guest Count - "+guestCount+" Message - "+clientMessage);
        }else{
            reservation.setReservationId(reservationId);
            reservation.setUserId(0);
            reservation.setReservationType(reservationType);
            reservation.setDateTime(reservationDate);
            reservation.setSub_type(reservationSubType);
            reservation.setGuestCount(Integer.parseInt(guestCount));
            reservation.setStatus("Booked");
            reservation.setNotes("Name - "+name+" Email - "+email+" Phone - "+phone+" Guest Count - "+guestCount+" Message - "+clientMessage);
        }

        boolean isSaved;

        if (reservationId > 0) {
            isSaved = reservationDAO.updateReservation(reservation); // Update existing reservation
        } else {
            isSaved = reservationDAO.addReservation(reservation); // Add new reservation
        }

        String message = "";

        if (isSaved) {
            message = "Your reservation booked successfully!";
            String url = "dashboard.jsp?message=" + URLEncoder.encode(message, "UTF-8");
            response.sendRedirect(url);
        } else {
            message = "Your reservation booking was not successful, please try again!";
            String url = "dashboard.jsp?message=" + URLEncoder.encode(message, "UTF-8");
            response.sendRedirect(url);
        }
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
