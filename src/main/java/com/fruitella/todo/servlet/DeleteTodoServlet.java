package com.fruitella.todo.servlet;


import com.fruitella.todo.DAO.TodoDaoImplement;
import com.fruitella.todo.entity.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteTodoServlet", value = "/delete_todo")
public class DeleteTodoServlet extends HttpServlet {
    private TodoDaoImplement todoDao;

    public void init() {
        todoDao = new TodoDaoImplement();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        long id = Long.parseLong(req.getParameter("id"));
        todoDao.deleteTodoById(id);
        req.getRequestDispatcher("/deleted_todo.jsp").forward(req, resp);
    }
}
