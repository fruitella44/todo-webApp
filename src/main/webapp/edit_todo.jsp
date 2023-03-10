<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 08.03.2023
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.fruitella.todo.entity.Todo" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Edit Todo</title>
</head>
<body>
<h1>Edit Todo</h1>
<% Todo todo = (Todo) request.getAttribute("todo"); %>

<form action="edit_todo" method="post">
  <input type="hidden" name="id" value="<%= todo.getId() %>">
  <label for="title">Title:</label>
  <input type="text" id="title" name="title" value="<%= todo.getTitle() != null ? todo.getTitle() : "" %>">
  <label for="description">Description:</label>
  <input type="text" id="description" name="description" value="<%= todo.getDescription() %>"><br>
  <label for="isDone">Is Done:</label>
  <select id="isDone" class="form-control" name="isDone">
    <option value="false">In Progress</option>
    <option value="true">Complete</option>
  </select>
  <label for="expiredDate">Expired Date:</label>
  <input type="date" id="expiredDate" name="expiredDate" value="<%= todo.getExpiredDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) %>"><br>
  <button type="submit">Update</button>
</form>

</body>
</html>

