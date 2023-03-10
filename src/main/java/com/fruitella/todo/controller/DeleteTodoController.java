package com.fruitella.todo.controller;


import com.fruitella.todo.DAO.TodoDaoImplement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteTodoController", value = "/new_form")
public class DeleteTodoController extends HttpServlet {
    private TodoDaoImplement todoDao;

    public void init() {
        todoDao = new TodoDaoImplement();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        long id = Long.parseLong(req.getParameter("id"));
        todoDao.deleteTodoById(id);
        session.setAttribute("todos", todoDao.getAllTodos());
        resp.sendRedirect("todo_list.jsp");
    }
}