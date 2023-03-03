package com.fruitella.todo.servlet;

import com.fruitella.todo.controller.UserService;
import com.fruitella.todo.controller.UserServiceImpl;
import com.fruitella.todo.entity.User;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", value = "/register")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            List<User> users = userService.getAllUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        } else {
            String[] pathParts = pathInfo.split("/");
            int userId = Integer.parseInt(pathParts[1]);
            User user = userService.getUserById(userId);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/user.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = User.builder()
                .username(username)
                .userPassword(password)
                .email(email)
                .build();

        UserService userService = new UserServiceImpl();
        userService.addUser(user);

        response.sendRedirect(request.getContextPath() + "/users");
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        int userId = Integer.parseInt(pathParts[1]);
        userService.deleteUser(userId);
        resp.sendRedirect(req.getContextPath() + "/users");
    }

}

