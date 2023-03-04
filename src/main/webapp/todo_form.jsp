<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 03.03.2023
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create New Todo</title>
</head>
<body>
<h1>Create New Todo</h1>
<form action="TodoServlet" method="POST">
        <%--@declare id="title"--%>
     <label for="title">Title:</label>
    <input type="text" name="title" required>
    <br>
        <%--@declare id="description"--%>
    <label for="description">Description:</label>
    <textarea name="description" required></textarea>
    <br>
        <%--@declare id="duedate"--%>
    <label for="dueDate">Due Date:</label>
    <input type="date" name="dueDate" required>
    <br>
    <input type="submit" value="Create">
</form>
</body>
</html>

