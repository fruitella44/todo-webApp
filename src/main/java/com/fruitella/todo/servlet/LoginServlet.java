package com.fruitella.todo.servlet;

import com.fruitella.todo.DAO.LoginDao;
import com.fruitella.todo.bean.LoginBean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        if (loginDao.validate(loginBean.getUsername(), loginBean.getPassword())) {
            response.sendRedirect("valid.jsp");
        } else {
            response.sendRedirect("invalid.jsp");
        }
    }
}

