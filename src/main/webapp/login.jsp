<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="CSS/login_css.css">
    <!-- Favicons -->
    <link href="Assets/logo_abc.png" rel="icon">
</head>
<body>
<%
    String message = request.getParameter("message");
%>
<script>
    // Check if the parameters are not null or empty before showing the alert
    <% if (message != null && !message.isEmpty()) { %>
    alert('Welcome, <%= message %>');
    <% } %>
</script>
<div class="container">
    <div class="left-side">
        <img class="logo-img" src="Assets/logo_abc.png" alt="Logo">
        <form action="login" method="post">
            <input type="text" placeholder="Username" name="username" required>
            <input type="password" placeholder="Password"  name="password" required>
            <button type="submit" value="Log in">Login</button>
            <hr>
            <button type="button" class="create-account-btn" onclick="window.location.href='register_client.jsp'">
                Create new account
            </button>
        </form>
        <footer>
            <p>© Product of ABC Restaurants group 2024</p>
            <a href="https://www.abcrestaurantsgroup.com">www.abcrestaurantsgroup.com</a>
        </footer>
    </div>
    <div class="right-side">
    </div>
</div>
</body>
</html>


