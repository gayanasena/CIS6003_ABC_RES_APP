<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - ABC Restaurant</title>
</head>
<body>
<h2>Login to ABC Restaurant</h2>
<form action="login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="Login">
</form>

<!-- Display error messages -->
<%
    String error = request.getParameter("error");
    if (error != null) {
        if (error.equals("InvalidCredentials")) {
            out.println("<p style='color:red;'>Invalid username or password</p>");
        } else if (error.equals("UnknownRole")) {
            out.println("<p style='color:red;'>Unknown user role</p>");
        }
    }
%>
</body>
</html>
