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

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Edit todo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>

<body>
<jsp:include page="common/header.jsp" />


<% Todo todo = (Todo) request.getAttribute("todo"); %>
<div class="container text-center">
  <div class="row justify-content-md-center">
    <h1 class="text-dark">Edit task №:<%= todo.getId()%> by @${username}</h1>
  </div>
</div>

<div class="label-center">
  <form action="edit_todo" method="post">
    <input type="hidden" name="id" value="<%= todo.getId() %>">

    <div class="form-group">
      <label for="title">Title</label>
      <input type="text" class="form-control middle-input" id="title" name="title"
             value="<%= todo.getTitle() != null ? todo.getTitle() : "" %>">
    </div>

    <div class="form-group">
      <label for="description">Description</label>
      <input type="text" class="form-control middle-input" id="description" name="description"
             value="<%= todo.getDescription() %>"><br>
    </div>

    <div class="form-group">
      <label for="isDone">Status</label>
      <select  class="form-control middle-input" id="isDone" name="isDone">
        <option value="false">In Progress</option>
        <option value="true">Complete</option>
      </select>
    </div>

    <div class="form-group">
      <label for="expiredDate">Deadline</label>
      <input type="date"  class="form-control middle-input" id="expiredDate" name="expiredDate"
             value="<%= todo.getExpiredDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) %>"><br>
      <button type="submit" class="btn btn-success">Submit</button>
    </div>
  </form>
</div>

<jsp:include page="common/footer.jsp" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
