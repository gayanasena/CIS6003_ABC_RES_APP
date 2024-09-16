package com.icbt.gayana.cis6003_abc.DAO;

import com.icbt.gayana.cis6003_abc.Model.Query;
import com.icbt.gayana.cis6003_abc.Model.User;
import com.icbt.gayana.cis6003_abc.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QueryDAO {

    // Method to add a new query
    public boolean addQuery(Query query) {
        String sql = "INSERT INTO queries (user_id, subject, message, status, created_at, response) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, query.getUserId());
            preparedStatement.setString(2, query.getSubject());
            preparedStatement.setString(3, query.getMessage());
            preparedStatement.setString(4, query.getStatus());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(query.getCreatedAt()));
            preparedStatement.setString(6, "");

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to get a list of all queries for a specific user (for Customers)
    public List<Query> getQueriesByUser(int userId) {
        List<Query> queryList = new ArrayList<>();
        String sql = "SELECT * FROM queries WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Query query = extractQueryFromResultSet(resultSet);
                queryList.add(query);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queryList;
    }

    // Method to get a query for a specific id
    public Query getQueryById(int queryId) {
        Query query = null;  // Initialize to null to handle the case where no result is found

        String sql = "SELECT * FROM queries WHERE query_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, queryId);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                // Extract the Query object from the ResultSet
                query = extractQueryFromResultSet(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;  // Return the Query object, or null if not found
    }


    // Method to get all queries (for Admin/Staff)
    public List<Query> getAllQueries() {
        List<Query> queryList = new ArrayList<>();
        String sql = "SELECT * FROM queries";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Query query = extractQueryFromResultSet(resultSet);
                queryList.add(query);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queryList;
    }

    // Method to update query status and add a response from staff
    public boolean updateQueryResponse(int queryId, String response, String status) {
        String sql = "UPDATE queries SET response = ?, status = ? WHERE query_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, response);
            preparedStatement.setString(2, status);
            preparedStatement.setInt(3, queryId);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to delete a query (optional)
    public boolean deleteQuery(int queryId) {
        String sql = "DELETE FROM queries WHERE query_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, queryId);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Helper method to extract a Query object from a ResultSet
    private Query extractQueryFromResultSet(ResultSet resultSet) throws SQLException {
        int queryId = resultSet.getInt("query_id");
        int userId = resultSet.getInt("user_id");
        String subject = resultSet.getString("subject");
        String message = resultSet.getString("message");
        String status = resultSet.getString("status");
        String response = resultSet.getString("response");
        LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

        // Fetch the user details (this assumes you have a UserDAO to get the user by ID)
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(userId);

        Query query = new Query();

        query.setQueryId(queryId);
        query.setUser(user);
        query.setSubject(subject);
        query.setMessage(message);
        query.setStatus(status);
        query.setResponse(response);
        query.setCreatedAt(createdAt);


        return query;
    }
}

