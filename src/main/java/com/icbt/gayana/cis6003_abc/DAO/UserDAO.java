package com.icbt.gayana.cis6003_abc.DAO;

import com.icbt.gayana.cis6003_abc.Model.User;
import com.icbt.gayana.cis6003_abc.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Method to register a new user
    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (username, email, password, full_name, phone, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFull_name());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getRole());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to check login credentials
    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);  // Assuming password is hashed

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String resultUsername = resultSet.getString("username");
                String role = resultSet.getString("role");
                String full_name = resultSet.getString("full_name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                return new User(id, resultUsername,email, password, full_name, phone, role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no match is found
    }

    // Method to find user by email
    public User findUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String full_name = resultSet.getString("full_name");
                String phone = resultSet.getString("phone");

                return new User(id,username, email, password, full_name, phone, role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to update user information
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET username = ?, email = ?, password = ?, role = ? WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());  // Assuming password is hashed
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setInt(5, user.getUser_id());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to delete a user
    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String email = resultSet.getString("email");
                String full_name = resultSet.getString("full_name");
                String phone = resultSet.getString("phone");

                return new User(id,username, email, password, full_name, phone, role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

