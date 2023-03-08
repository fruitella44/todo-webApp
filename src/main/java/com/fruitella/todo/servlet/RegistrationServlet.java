package com.fruitella.todo.servlet;

import com.fruitella.todo.DAO.UserDaoImplement;
import com.fruitella.todo.entity.Users;
import com.fruitella.todo.hasher.PasswordHasher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegistrationServlet", value = "/sign_up")
public class RegistrationServlet extends HttpServlet {

    private UserDaoImplement userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDaoImplement();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        session.setAttribute("username", username);
        session.setAttribute("password", password);
        session.setAttribute("email", email);

        Users user = Users.builder()
                .username(username)
                .userPassword(PasswordHasher.hashPassword(password))
                .email(email)
                .build();

        userDao.addUser(user);
        req.getRequestDispatcher("sign_in.jsp").forward(req, resp);
    }

}
