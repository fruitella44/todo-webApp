package com.fruitella.todo.controller;

import com.fruitella.todo.DAO.UserDaoImplement;
import com.fruitella.todo.entity.Users;
import com.fruitella.todo.hasher.PasswordHasher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegistrationController", value = "/sign_up")
public class RegistrationController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationController.class);

    private UserDaoImplement userDao;

    @Override
    public void init() {
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
        LOGGER.debug("Set attributes: [username, password, email] to Session");

        Users user = Users.builder()
                .username(username)
                .userPassword(PasswordHasher.hashPassword(password))
                .email(email)
                .build();
        userDao.addUser(user);

        req.setAttribute("Notification", "Registration successful");
        req.getRequestDispatcher("sign_in.jsp").forward(req, resp);
        LOGGER.debug("Commit action: [Insert new user to table users]. Send redirect to login page");
    }

}
