package com.fruitella.todo.servlet;

import com.fruitella.todo.DAO.LoginUserDao;
import com.fruitella.todo.bean.AuthorisationBean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", value = "/sign_in")
public class LoginServlet extends HttpServlet {

    private LoginUserDao loginDao;

    public void init() {
        loginDao = new LoginUserDao();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        session.setAttribute("username", username);
        session.setAttribute("password", password);

        AuthorisationBean userBean = new AuthorisationBean();
        userBean.setUsername(username);
        userBean.setPassword(password);


        if (loginDao.validate(userBean.getUsername(), userBean.getPassword())) {
            resp.sendRedirect("todo_list.jsp");
        } else {
            req.setAttribute("Notification", "Invalid login or password");
            req.getRequestDispatcher("sign_in.jsp").forward(req, resp);
        }
    }
}

