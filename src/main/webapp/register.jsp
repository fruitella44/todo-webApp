<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.03.2023
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="register" method="post">
    <%--@declare id="username"--%>
    <%--@declare id="password"--%>
    <%--@declare id="confirmpassword"--%>
    <%--@declare id="email"--%>
    <label for="username">Username:</label>
    <input type="text" name="username" required><br>

    <label for="password">Password:</label>
    <input type="password" name="password" required><br>

    <label for="confirmPassword">Confirm Password:</label>
    <input type="password" name="confirmPassword" required><br>

     <label for="email">Email:</label>
     <input type="email" name="email" required><br>

    <button type="submit">Register</button>
</form>
</body>
</html>

