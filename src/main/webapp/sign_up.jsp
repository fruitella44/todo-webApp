<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.03.2023
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create new account</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body style="background-image: url('https://i.imgur.com/8VDQRPg.jpg')">
<jsp:include page="common/header.jsp" />

<div class="position-relative">
    <div class="position-absolute top-20 start-50 translate-middle-x">
        <div class="container col-md-12 col-md-offset-3" style="overflow: auto">
            <h2 class="text-dark">New account</h2>

            <form action="sign_up" method="post">
                <div class="form-group">
                    <label for="username" class="text-dark">Username</label>
                    <input type="text" class="form-control middle-input" id="username" placeholder="Login" name="username" required><br>
                </div>

                <div class="form-group">
                    <label for="password" class="text-dark">Password</label>
                    <input type="password" class="form-control middle-input" id="password" placeholder="Password" name="password" required><br>
                </div>

                <div class="form-group">
                    <label for="confirmPassword" class="text-dark">Confirm password</label>
                    <input type="password" class="form-control middle-input" id="confirmPassword" placeholder="Password" name="confirmPassword" required><br>
                </div>

                <div class="form-group">
                    <label for="email" class="text-dark">Email</label>
                    <input type="email" class="form-control middle-input" id="email" placeholder="Email" name="email" required><br>
                    <button type="submit" class="btn btn-success">Submit</button>
                </div>
            </form>

            <div class="link-on-page">
                <h6 class="text-dark">I already have an account
                    <a href="sign_in.jsp">Login</a>
                </h6>
            </div>

        </div>
    </div>
</div>

<jsp:include page="common/footer.jsp" />

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
