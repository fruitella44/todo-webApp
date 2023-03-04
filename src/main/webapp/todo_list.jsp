<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 03.03.2023
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>
<table>
  <thead>
  <tr>
    <th>Title</th>
    <th>Description</th>
    <th>Due Date</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${todos}" var="todo">
    <tr>
      <td>${todo.title}</td>
      <td>${todo.description}</td>
      <td>${todo.dueDate}</td>
      <td>
        <a href="TodoServlet?id=${todo.id}&action=edit">Edit</a>
        <a href="TodoServlet?id=${todo.id}&action=delete">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="todo_form.jsp">Create New Todo</a></p>
</body>
</html>

