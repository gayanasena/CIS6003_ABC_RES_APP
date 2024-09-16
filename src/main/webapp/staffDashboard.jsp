<%@ page import="com.icbt.gayana.cis6003_abc.Model.User" %>
<%@ page import="com.icbt.gayana.cis6003_abc.Model.Reservation" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<% User user = (User) request.getAttribute("user");%>
<% List<Reservation> reservations  = (List<Reservation>) request.getAttribute("reservations");%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Staff Dashboard - ABC Restaurant</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .container {
      margin-top: 20px;
    }
  </style>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">ABC Restaurant</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/client">Dashboard</a>
      </li>
      <li class="nav-item">
<%--        <a class="nav-link" href="makeReservation.jsp">Make Reservation</a>--%>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="logout">Logout</a>
      </li>
    </ul>
  </div>
</nav>

<div class="container">
  <!-- Profile Section -->
  <div class="card mb-4">
    <div class="card-header">
      Your Profile
    </div>
    <div class="card-body">
      <p><strong>Username:</strong> <%= user.getUsername() %></p>
      <p><strong>Email:</strong> <%= user.getEmail() %></p>
    </div>
  </div>

  <!-- Reservations Section -->
  <div class="card mb-4">
    <div class="card-header">
      Your Reservations
    </div>
    <div class="card-body">
      <table class="table table-striped">
        <thead>
        <tr>
          <th>Reservation ID</th>
          <th>Date</th>
          <th>Type</th>
          <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <!-- Example data -->
        <%
          for (Reservation res : reservations) {
        %>
        <tr>
          <td><%= res.getReservationId() %></td>
          <td><%= res.getCreated_at() %></td>
          <td><%= res.getReservationType() %></td>
          <td><%= res.getStatus() %></td>
        </tr>
        <% } %>
        </tbody>
      </table>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
