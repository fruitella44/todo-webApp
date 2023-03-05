<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 03.03.2023
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Create New Todo</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Create New Todo</h1>--%>
<%--<form action="TodoServlet" method="POST">--%>
<%--        &lt;%&ndash;@declare id="title"&ndash;%&gt;--%>
<%--     <label for="title">Title:</label>--%>
<%--    <input type="text" name="title" required>--%>
<%--    <br>--%>
<%--        &lt;%&ndash;@declare id="description"&ndash;%&gt;--%>
<%--    <label for="description">Description:</label>--%>
<%--    <textarea name="description" required></textarea>--%>
<%--    <br>--%>
<%--        &lt;%&ndash;@declare id="duedate"&ndash;%&gt;--%>
<%--    <label for="dueDate">Due Date:</label>--%>
<%--    <input type="date" name="dueDate" required>--%>
<%--    <br>--%>
<%--    <input type="submit" value="Create">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>


<!DOCTYPE html>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>
<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Is Done?</th>
        <th>Created Date</th>
        <th>Expired Date</th>
        <th>Username</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todoList}" var="todo">
        <tr>
            <td>${todo.title}</td>
            <td>${todo.description}</td>
            <td>${todo.isDone}</td>
            <td>${todo.createdDate}</td>
            <td>${todo.expiredDate}</td>
            <td>${todo.username}</td>
            <td>
                <a href="edit?id=${todo.id}">Edit</a>
                <a href="delete?id=${todo.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="new">Add New Todo</a>
</body>
</html>

