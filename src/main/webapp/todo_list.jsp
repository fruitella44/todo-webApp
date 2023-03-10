<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Alex--%>
<%--  Date: 03.03.2023--%>
<%--  Time: 23:39--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page import="com.fruitella.todo.entity.Todo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>
<% List<Todo> todos = (List<Todo>) session.getAttribute("todos"); %>

<% if (todos != null && !todos.isEmpty()) { %>

<table>
  <tr>
    <th>Title</th>
    <th>Description</th>
    <th>Complete</th>
    <th>Expired Date</th>
    <th>Action</th>
  </tr>

  <% for (Todo todo : todos) { %>
  <tr>
    <td><%= todo.getTitle() %></td>
    <td><%= todo.getDescription() %></td>
    <td><%= todo.getIsDone() %></td>
    <td><%= todo.getExpiredDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) %></td>
    <td>
      <form action="new_form" method="post">
        <input type="hidden" name="id" value="<%= todo.getId() %>">
        <button type="submit">Delete</button>
      </form>

      <form action="edit_todo" method="get">
        <input type="hidden" name="id" value="<%= todo.getId() %>">
        <button type="submit">Edit</button>
      </form>
    </td>
  </tr>
  <% } %>
</table>
<% } else { %>
<p>Todo is empty</p>
<% } %>

<form action="todo_list" method="post" >
  <input type="text" name="title" placeholder="Title">
  <input type="text" name="description" placeholder="Description">
  <input type="checkbox" name="status" value="true">Is Done
  <input type="date" name="expiredDate" placeholder="Expired Date">
  <button type="submit">Add</button>
</form>

</body>
</html>
