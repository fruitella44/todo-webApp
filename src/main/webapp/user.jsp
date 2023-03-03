<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.03.2023
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Details</title>
</head>
<body>
<h1>User Details</h1>
<table>
    <tr>
        <td>Username:</td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td>Password:</td>
        <td>${user.password}</td>
    </tr>
</table>
</body>
</html>
