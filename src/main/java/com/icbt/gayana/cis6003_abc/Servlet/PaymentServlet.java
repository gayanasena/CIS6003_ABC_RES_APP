package com.icbt.gayana.cis6003_abc.Servlet;

import com.icbt.gayana.cis6003_abc.DAO.PaymentDAO;
import com.icbt.gayana.cis6003_abc.DAO.ReservationDAO;
import com.icbt.gayana.cis6003_abc.Model.Payment;
import com.icbt.gayana.cis6003_abc.Model.Reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

    private PaymentDAO paymentDAO;

    @Override
    public void init() throws ServletException {
        paymentDAO = new PaymentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a new payment
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));

        double amount = Double.parseDouble(request.getParameter("amount"));
        String paymentMethod = request.getParameter("paymentMethod");
        String paymentStatus = request.getParameter("paymentStatus");
        LocalDateTime paymentDate = LocalDateTime.now();

        ReservationDAO reservationDAO = new ReservationDAO();

        Reservation reservation = reservationDAO.getReservationById(reservationId);

        Payment payment = new Payment(0, reservation, amount, paymentMethod, paymentStatus, paymentDate);

        boolean isAdded = paymentDAO.addPayment(payment);
        if (isAdded) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve payment by ID
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        Payment payment = paymentDAO.getPaymentById(paymentId);

        if (payment != null) {
            request.setAttribute("payment", payment);
            request.getRequestDispatcher("paymentDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}


