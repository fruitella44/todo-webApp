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
    <title>Registration</title>
</head>
<body>
<h1>Create new account</h1>
<form action="sign_up" method="post">

        <%--@declare id="username"--%>
    <label for="username">Username:</label>
    <input type="text" name="username" required><br>

        <%--@declare id="password"--%>
    <label for="password">Password:</label>
    <input type="password" name="password" required><br>

        <%--@declare id="confirmpassword"--%>
    <label for="confirmPassword">Confirm password:</label>
    <input type="password" name="confirmPassword" required><br>

        <%--@declare id="email"--%>
     <label for="email">Email:</label>
     <input type="email" name="email" required><br>

    <button type="submit">Register</button>
</form>
</body>

</html>
