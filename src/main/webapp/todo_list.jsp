<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Alex--%>
<%--  Date: 03.03.2023--%>
<%--  Time: 23:39--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


