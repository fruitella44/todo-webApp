<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.03.2023
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<table>
    <thead>
    <tr>
        <th>Username</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

