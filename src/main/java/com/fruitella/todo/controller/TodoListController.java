package com.fruitella.todo.controller;


import com.fruitella.todo.entity.Todo;
import com.fruitella.todo.entity.Users;
import com.fruitella.todo.service.TodoService;
import com.fruitella.todo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "TodoListController", value = "/todo_list")
public class TodoListController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(TodoListController.class);

    private UserService userService;
    private TodoService todoService;

    public void init() {
        userService = new UserService();
        todoService = new TodoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");
        LOGGER.debug("Session active for user: " + username);

        if (username != null) {
            List<Todo> todoList = todoService.getAllTodos(username);
            req.setAttribute("todos", todoList);
            req.getRequestDispatcher("todo/todo_list.jsp").forward(req, resp);
            LOGGER.debug("Get all todos with size: " + todoList.size());
        } else {
            resp.sendRedirect( "/sign_in.jsp");
            LOGGER.debug("User = null. Send redirect to login page" );
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        boolean status = Boolean.parseBoolean(req.getParameter("isDone"));
        LocalDate expiredDate = LocalDate.parse(req.getParameter("expiredDate"));

        Users user = userService.getUserByUsername(username);
        LOGGER.debug("User with " + username + " is adding new task");

        Todo todo = Todo.builder()
                .users(user)
                .title(title)
                .description(description)
                .isDone(status)
                .expiredDate(expiredDate)
                .build();
        todoService.addTodo(todo);
        LOGGER.debug("Commit action - [Insert new task] with id: " + todo.getId());

        List<Todo> todos = todoService.getAllTodos(username);
        session.setAttribute("todos", todos);

        req.setAttribute("Notification", "Todo added successfully");
        req.getRequestDispatcher("/todo_list.jsp").forward(req, resp);
        LOGGER.debug("Task added successfully. Redirect to the same page. Show updated form");
    }

}

