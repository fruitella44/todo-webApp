package com.fruitella.todo.controller;

import com.fruitella.todo.DAO.TodoDaoImplement;
import com.fruitella.todo.DAO.UserDaoImplement;
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

@WebServlet(name = "EditTodoController", value = "/edit_todo")
public class EditTodoController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(EditTodoController.class);
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
        long id = Long.parseLong(req.getParameter("id"));
        Todo todo = todoService.getTodoById(id);
        LOGGER.debug("Found task with id: " + id);

        req.setAttribute("todo", todo);
        session.setAttribute("todos", todoService.getAllTodos(username));
        req.getRequestDispatcher("/edit_todo.jsp").forward(req, resp);
        LOGGER.debug("Send redirect to edit_todo page");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");
        long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        boolean isDone = Boolean.parseBoolean(req.getParameter("isDone"));
        LocalDate expiredDate = LocalDate.parse(req.getParameter("expiredDate"));

        Users user = userService.getUserByUsername(username);
        LOGGER.debug("User with " + username + " is changing existed task");

        Todo todo = Todo.builder()
                .id(id)
                .users(user)
                .title(title)
                .description(description)
                .isDone(isDone)
                .expiredDate(expiredDate)
                .build();
        todoService.updateTodo(todo);
        LOGGER.debug("Commit action - [Update task] with id: " + id);

        session.setAttribute("todos", todoService.getAllTodos(username));
        resp.sendRedirect("todo_list.jsp");
        LOGGER.debug("Send redirect with updated form");
    }
}
