package com.fruitella.todo.servlet;

import com.fruitella.todo.DAO.LoginUserDao;
import com.fruitella.todo.bean.AuthorisationBean;
import com.fruitella.todo.hasher.PasswordHasher;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private LoginUserDao loginDao;

    public void init() {
        loginDao = new LoginUserDao();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AuthorisationBean userBean = new AuthorisationBean();
        userBean.setUsername(username);
        userBean.setPassword(password);

        //Check validation of login and pass
//        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        if (loginDao.validate(userBean.getUsername(), userBean.getPassword())) {
            response.sendRedirect("todo_form.jsp");
        } else {
            request.setAttribute("Notification", "Invalid login or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}

