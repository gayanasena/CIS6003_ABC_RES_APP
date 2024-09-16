<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registration Form</title>
  <link rel="stylesheet" href="CSS/register_client.css">
  <!-- Favicons -->
  <link href="Assets/logo_abc.png" rel="icon">
</head>
<body>
<div class="registration-form">
  <h2>User Register</h2>
  <form action="register" method="POST">
    <input type="text" id="username" name="username" placeholder="Username" required>

    <input type="password" id="password" name="password" placeholder="Password" required>

    <input type="text" id="full_name" name="full_name" placeholder="Full Name" required>

    <input type="email" id="email" name="email" placeholder="Email" required>

    <input type="tel" id="phone" name="phone" placeholder="Phone Number" required>

    <input type="hidden" name="role" value="client" />

    <div class = "register-button">
      <button type="submit">Register</button>
    </div>
  </form>
</div>
</body>
</html>

