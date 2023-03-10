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
  <title>Todo list</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="/css/style.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body style="background-image: url('https://i.imgur.com/8VDQRPg.jpg')">
<jsp:include page="common/header.jsp" />
<% List<Todo> todos = (List<Todo>) session.getAttribute("todos"); %>

<div class="container text-center">
  <div class="row justify-content-md-center">
    <h1 class="text-dark">Todo tasks</h1>
  </div>
</div>

<% if (todos != null && !todos.isEmpty()) { %>

<div class="row justify-content-md-center">
  <table class="table table-sm" id="table_1">
    <thead>
    <tr>
      <th class="bg-light">Title</th>
      <th class="bg-light">Description</th>
      <th class="bg-light">Complete</th>
      <th class="bg-light">Expired Date</th>
      <th class="bg-light">Action</th>
    </tr>
    </thead>
  </table>
</div>


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

<%--<table>--%>
<%--  <tr>--%>
<%--    <th>Title</th>--%>
<%--    <th>Description</th>--%>
<%--    <th>Complete</th>--%>
<%--    <th>Expired Date</th>--%>
<%--    <th>Action</th>--%>
<%--  </tr>--%>

<%--  <% for (Todo todo : todos) { %>--%>
<%--  <tr>--%>
<%--    <td><%= todo.getTitle() %></td>--%>
<%--    <td><%= todo.getDescription() %></td>--%>
<%--    <td><%= todo.getIsDone() %></td>--%>
<%--    <td><%= todo.getExpiredDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) %></td>--%>
<%--    <td>--%>
<%--      <form action="new_form" method="post">--%>
<%--        <input type="hidden" name="id" value="<%= todo.getId() %>">--%>
<%--        <button type="submit">Delete</button>--%>
<%--      </form>--%>

<%--      <form action="edit_todo" method="get">--%>
<%--        <input type="hidden" name="id" value="<%= todo.getId() %>">--%>
<%--        <button type="submit">Edit</button>--%>
<%--      </form>--%>
<%--    </td>--%>
<%--  </tr>--%>
<%--  <% } %>--%>
<%--</table>--%>
<%--<% } else { %>--%>
<%--<p>Todo is empty</p>--%>
<%--<% } %>--%>

<%--<form action="todo_list" method="post" >--%>
<%--  <input type="text" name="title" placeholder="Title">--%>
<%--  <input type="text" name="description" placeholder="Description">--%>
<%--  <input type="checkbox" name="status" value="true">Is Done--%>
<%--  <input type="date" name="expiredDate" placeholder="Expired Date">--%>
<%--  <button type="submit">Add</button>--%>
<%--</form>--%>

<jsp:include page="common/footer.jsp" />

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
