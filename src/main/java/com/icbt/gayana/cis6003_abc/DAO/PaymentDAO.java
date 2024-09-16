package com.icbt.gayana.cis6003_abc.DAO;

import com.icbt.gayana.cis6003_abc.Model.Payment;
import com.icbt.gayana.cis6003_abc.Model.Reservation;
import com.icbt.gayana.cis6003_abc.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;

public class PaymentDAO {

    // Method to add a new payment
    public boolean addPayment(Payment payment) {
        String sql = "INSERT INTO payments (reservation_id, amount, payment_method, payment_status, payment_date) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, payment.getReservation().getReservationId());
            preparedStatement.setDouble(2, payment.getAmount());
            preparedStatement.setString(3, payment.getPaymentMethod());
            preparedStatement.setString(4, payment.getPaymentStatus());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(payment.getPaymentDate()));

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to get payment details by ID
    public Payment getPaymentById(int paymentId) {
        String sql = "SELECT * FROM payments WHERE payment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, paymentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return extractPaymentFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to update payment status
    public boolean updatePaymentStatus(int paymentId, String paymentStatus) {
        String sql = "UPDATE payments SET payment_status = ? WHERE payment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, paymentStatus);
            preparedStatement.setInt(2, paymentId);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to delete a payment (optional)
    public boolean deletePayment(int paymentId) {
        String sql = "DELETE FROM payments WHERE payment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, paymentId);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Helper method to extract a Payment object from a ResultSet
    private Payment extractPaymentFromResultSet(ResultSet resultSet) throws SQLException {
        int paymentId = resultSet.getInt("payment_id");
        int reservationId = resultSet.getInt("reservation_id");
        double amount = resultSet.getDouble("amount");
        String paymentMethod = resultSet.getString("payment_method");
        String paymentStatus = resultSet.getString("payment_status");
        LocalDateTime paymentDate = resultSet.getTimestamp("payment_date").toLocalDateTime();

        // Fetch the reservation details (this assumes you have a ReservationDAO to get the reservation by ID)
        ReservationDAO reservationDAO = new ReservationDAO();
        Reservation reservation = reservationDAO.getReservationById(reservationId);

        return new Payment(paymentId, reservation, amount, paymentMethod, paymentStatus, paymentDate);
    }
}

