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

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Todo list</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="/css/style.css" rel="stylesheet">
  <script src="script/viewScript.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>

<body>
<jsp:include page="common/header.jsp" />
<% List<Todo> todos = (List<Todo>) session.getAttribute("todos"); %>

<div class="container text-center">
  <div class="row justify-content-md-center">
    <h1 class="text-dark">Welcome @${username}</h1>
    <h2 class="text-dark">Todo tasks</h2>
  </div>
</div>

<% if (todos != null && !todos.isEmpty()) { %>

<div class="container text-center">
  <div class="row justify-content-md-center">

    <div class="task-table">
      <table class="table table-sm">
        <thead>
        <tr class="bg-info">
          <th scope="col">Task</th>
          <th scope="col">Title</th>
          <th scope="col">Description</th>
          <th scope="col">Status</th>
          <th scope="col">Deadline</th>
          <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>

        <% for (Todo todo : todos) { %>

        <tr>
          <td class="table-info"><%= todo.getId()%></td>
          <td class="table-info"><%= todo.getTitle() %></td>
          <td class="table-info"><%= todo.getDescription() %></td>
          <td class="table-info"><% if (todo.getIsDone()) { %> Complete <% } else { %> In progress <% } %></td>
          <td class="table-info"><%= todo.getExpiredDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) %></td>
          <td class="table-info">
            <div class="btn-group">
              <form action="edit_todo" method="get">
                <input type="hidden" name="id" value="<%= todo.getId() %>">
                <button type="submit" class="btn btn-primary">Edit</button>
              </form>

              <form action="new_form" method="post">
                <input type="hidden" name="id" value="<%= todo.getId() %>">
                <button type="submit" class="btn btn-danger">Delete</button>
              </form>
            </div>
          </td>

        </tr>
        <% } %>
        <% } else { %><p id="emptyList">Todo task is empty</p><% } %>
        </tbody>
      </table>
    </div>
  </div>
</div>

<div class="container text-center">
  <h2 class="text-dark">Add new Todo</h2>
</div>

<div class="label-center">
  <form action="todo_list" method="post">
    <div class="label-spacing">
      <div class="form-group">
        <input type="text" class="form-control middle-input" name="title" placeholder="Title">
      </div>
    </div>

    <div class="label-spacing">
      <div class="form-group">
        <input type="text" class="form-control middle-input" name="description" placeholder="Description">
      </div>
    </div>

    <div class="label-spacing">
      <div class="form-group">
        <select class="form-control middle-input" id="isDone" name="isDone">
          <option value="false">In Progress</option>
          <option value="true">Complete</option>
        </select>
      </div>
    </div>

    <div class="label-spacing">
      <div class="form-group">
        <input type="date" class="form-control middle-input" name="expiredDate" placeholder="Expired Date">
      </div>
    </div>

    <div class="label-spacing">
      <button type="submit" class="btn btn-success">Submit</button>
    </div>

    <div class="alert alert-login center" role="alert">
      <p style="color:#3cc31c;">${Notification}</p>
    </div>
  </form>
</div>


<jsp:include page="common/footer.jsp" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
