package com.icbt.gayana.cis6003_abc.DAO;

import com.icbt.gayana.cis6003_abc.Model.ActionLog;
import com.icbt.gayana.cis6003_abc.Model.User;
import com.icbt.gayana.cis6003_abc.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActionLogDAO {

    // Method to add a new action log
    public boolean addActionLog(ActionLog actionLog) {
        String sql = "INSERT INTO query_responses (user_id, action_description, action_date) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, actionLog.getUser().getUser_id());
            preparedStatement.setString(2, actionLog.getActionDescription());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(actionLog.getActionDate()));

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to get action logs by user (optional)
    public List<ActionLog> getActionLogsByUser(int userId) {
        List<ActionLog> actionLogs = new ArrayList<>();
        String sql = "SELECT * FROM query_responses WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                actionLogs.add(extractActionLogFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actionLogs;
    }

    // Helper method to extract ActionLog object from ResultSet
    private ActionLog extractActionLogFromResultSet(ResultSet resultSet) throws SQLException {
        int actionId = resultSet.getInt("action_id");
        int userId = resultSet.getInt("user_id");
        String actionDescription = resultSet.getString("action_description");
        LocalDateTime actionDate = resultSet.getTimestamp("action_date").toLocalDateTime();

        // Fetch the user details (this assumes you have a UserDAO to get the user by ID)
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(userId);

        return new ActionLog(actionId, user, actionDescription, actionDate);
    }
}
