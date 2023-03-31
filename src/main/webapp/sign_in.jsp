<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 03.03.2023
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>

<body>
<jsp:include page="common/header.jsp" />

<div class="position-absolute top-0 start-50 translate-middle-x">
    <div class="container col-md-8 col-md-offset-3" style="overflow: auto">
        <h2 class="text-dark">Login form</h2>

        <form action="sign_in" method="post">
            <div class="form-group">
                <label for="username" class="text-dark">Username</label>
                <input type="text" class="form-control small-input" id="username" placeholder="Login" name="username" required><br>
            </div>

            <div class="form-group">
                <label for="password" class="text-dark">Password</label>
                <input type="password" class="form-control small-input" id="password" placeholder="Password" name="password" required><br>
                <button type="submit" class="btn btn-success">Submit</button>
            </div>

            <div class="alert alert-login center" role="alert">
                <p style="color: red">${Notification}</p>
            </div>
        </form>

        <div class="link-on-page">
            <h6 class="text-dark">I don't have an account yet
                <a href="sign_up.jsp">Create new account</a>
            </h6>
        </div>
    </div>
</div>

<jsp:include page="common/footer.jsp" />

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
