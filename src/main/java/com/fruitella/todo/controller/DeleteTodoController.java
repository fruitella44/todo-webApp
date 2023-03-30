package com.fruitella.todo.controller;


import com.fruitella.todo.DAO.TodoDaoImplement;
import com.fruitella.todo.service.TodoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteTodoController", value = "/new_form")
public class DeleteTodoController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(DeleteTodoController.class);
    private TodoService todoService;

    public void init() {
        todoService = new TodoService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");
        long id = Long.parseLong(req.getParameter("id"));
        todoService.deleteTodoById(id);
        LOGGER.debug("Commit action - [Delete task] with id: " + id);

        session.setAttribute("todos", todoService.getAllTodos(username));
        resp.sendRedirect("todo_list.jsp");
        LOGGER.debug("Send redirect with updated form");
    }
}
