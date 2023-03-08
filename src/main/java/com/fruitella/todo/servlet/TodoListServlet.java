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
import java.util.List;

@WebServlet(name = "TodoListServlet", value = "/todo_list")
public class TodoListServlet extends HttpServlet {
    private TodoDaoImplement todoDao;

    public void init() {
        todoDao = new TodoDaoImplement();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        List<Todo> todoList = todoDao.getAllTodos();
        req.setAttribute("todoList", todoList);
        req.getRequestDispatcher("/todo_list.jsp").forward(req, resp);
    }

}

