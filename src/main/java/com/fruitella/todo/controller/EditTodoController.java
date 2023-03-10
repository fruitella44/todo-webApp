package com.fruitella.todo.controller;

import com.fruitella.todo.DAO.TodoDaoImplement;
import com.fruitella.todo.DAO.UserDaoImplement;
import com.fruitella.todo.entity.Todo;
import com.fruitella.todo.entity.Users;

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

    private TodoDaoImplement todoDao;
    private UserDaoImplement userDao;

    public void init() {
        todoDao = new TodoDaoImplement();
        userDao = new UserDaoImplement();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        long id = Long.parseLong(req.getParameter("id"));
        Todo todo = todoDao.getTodoById(id);
        req.setAttribute("todo", todo);
        session.setAttribute("todos", todoDao.getAllTodos());
        req.getRequestDispatcher("/edit_todo.jsp").forward(req, resp);
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

        Users user = userDao.getUserByUsername(username);

        Todo todo = Todo.builder()
                .id(id)
                .users(user)
                .title(title)
                .description(description)
                .isDone(isDone)
                .expiredDate(expiredDate)
                .build();
        todoDao.updateTodo(todo);

        session.setAttribute("todos", todoDao.getAllTodos());
        resp.sendRedirect("todo_list.jsp");
    }
}
