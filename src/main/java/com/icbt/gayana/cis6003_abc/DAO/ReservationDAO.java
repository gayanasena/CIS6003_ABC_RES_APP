package com.icbt.gayana.cis6003_abc.DAO;

import com.icbt.gayana.cis6003_abc.Model.Reservation;
import com.icbt.gayana.cis6003_abc.util.DatabaseConnection;

import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    // Add a new reservation to the database
    public boolean addReservation(Reservation reservation) {
        String sql = "INSERT INTO reservations (user_id, reservation_type, date_time, guest_count, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, reservation.getUserId());
            preparedStatement.setString(2, reservation.getReservationType());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(reservation.getDateTime()));
            preparedStatement.setInt(4, reservation.getGuestCount());
            preparedStatement.setString(5, reservation.getStatus());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve a reservation by its ID
    public Reservation getReservationById(int reservationId) {
        String sql = "SELECT * FROM reservations WHERE reservation_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, reservationId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservation_id"));

                reservation.setUserId(resultSet.getInt("user_id"));
                reservation.setReservationType(resultSet.getString("reservation_type"));
                reservation.setDateTime(resultSet.getTimestamp("date_time").toLocalDateTime());
                reservation.setGuestCount(resultSet.getInt("guest_count"));
                reservation.setStatus(resultSet.getString("status"));
                reservation.setCreated_at(resultSet.getTimestamp("created_at").toLocalDateTime());

                return reservation;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve all reservations for a specific user
    public List<Reservation> getReservationsByUserId(int userId) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservation_id"));

                reservation.setUserId(userId);
                reservation.setReservationType(resultSet.getString("reservation_type"));
                reservation.setDateTime(resultSet.getTimestamp("date_time").toLocalDateTime());
                reservation.setGuestCount(resultSet.getInt("guest_count"));
                reservation.setStatus(resultSet.getString("status"));
                reservation.setCreated_at(resultSet.getTimestamp("created_at").toLocalDateTime());

                reservations.add(reservation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    // Update an existing reservation
    public boolean updateReservation(Reservation reservation) {
        String sql = "UPDATE reservations SET reservation_type = ?, date_time = ?, guest_count = ?, status = ? WHERE reservation_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, reservation.getReservationType());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(reservation.getDateTime()));
            preparedStatement.setInt(3, reservation.getGuestCount());
            preparedStatement.setString(4, reservation.getStatus());
            preparedStatement.setInt(5, reservation.getReservationId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a reservation by its ID
    public boolean deleteReservation(int reservationId) {
        String sql = "DELETE FROM reservations WHERE reservation_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, reservationId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve all reservations (for internal admin or staff viewing)
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservation_id"));

                reservation.setUserId(resultSet.getInt("user_id"));
                reservation.setReservationType(resultSet.getString("reservation_type"));
                reservation.setDateTime(resultSet.getTimestamp("date_time").toLocalDateTime());
                reservation.setGuestCount(resultSet.getInt("guest_count"));
                reservation.setStatus(resultSet.getString("status"));
                reservation.setCreated_at(resultSet.getTimestamp("created_at").toLocalDateTime());

                reservations.add(reservation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
