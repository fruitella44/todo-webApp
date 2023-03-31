package com.fruitella.todo.controller;

import com.fruitella.todo.DAO.LoginUserDao;
import com.fruitella.todo.bean.AuthorisationBean;
import com.fruitella.todo.entity.Todo;
import com.fruitella.todo.service.TodoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", value = "/sign_in")
public class LoginController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
    private LoginUserDao loginDao;
    private TodoService todoService;

    public void init() {
        loginDao = new LoginUserDao();
        todoService = new TodoService();
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
        LOGGER.debug("Set username + password to AuthorisationBean");

        if (loginDao.validate(userBean.getUsername(), userBean.getPassword())) {
            LOGGER.debug("User: " + username + " authorized successfully");

            List<Todo> todos = todoService.getAllTodos(username);
            session.setAttribute("todos", todos);
            resp.sendRedirect("/todo_list.jsp");
        } else {
            req.setAttribute("Notification", "Invalid login or password");
            req.getRequestDispatcher("/sign_in.jsp").forward(req, resp);
            LOGGER.debug("Invalid login or password. Send redirect to login page");
        }
    }
}

