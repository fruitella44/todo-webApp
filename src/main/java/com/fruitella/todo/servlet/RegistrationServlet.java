package com.fruitella.todo.servlet;

import com.fruitella.todo.DAO.UserDaoImplement;
import com.fruitella.todo.entity.Users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrationServlet", value = "/sign_up")
public class RegistrationServlet extends HttpServlet {

    private UserDaoImplement userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDaoImplement();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Users user = Users.builder()
                .username(username)
                .userPassword(password)
                .email(email)
                .build();

        userDao.addUser(user);
        response.sendRedirect("login.jsp");
    }

}
