<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 03.03.2023
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>

<h2>Todo Application</h2>
<form action="sign_in" method="post">
    <label for="username">Имя пользователя:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="password">Пароль:</label>
    <input type="password" id="password" name="password" required><br>
    <input type="submit" value="Login">

    <div class="alert alert-login center" role="alert">
        <p style="color:red;">${Notification}</p>
    </div>
</form>

<p>I don't have an account <a href="sign_up.jsp"> Create new account</a></p>
</body>
</html>
