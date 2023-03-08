package com.fruitella.todo.servlet;

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
import java.util.List;


@WebServlet(name = "NewTodoServlet", value = "/new_todo")
public class NewTodoServlet extends HttpServlet {
    private TodoDaoImplement todoDao;
    private UserDaoImplement userDao;

    public void init() {
        todoDao = new TodoDaoImplement();
        userDao = new UserDaoImplement();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/todo_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        String username = (String) session.getAttribute("username");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        boolean status = Boolean.valueOf(req.getParameter("status"));
        LocalDate expiredDate = LocalDate.parse(req.getParameter("expiredDate"));

        Todo todo = Todo.builder()
                .title(title)
                .description(description)
                .isDone(status)
                .expiredDate(expiredDate)
                .build();

        Users user = userDao.getUserByUsername(username);
        todo.setUsers(user);
        todoDao.addTodo(todo);

        List<Todo> todos = todoDao.getAllTodos();
        session.setAttribute("todos", todos);
        req.setAttribute("Notification", "Todo added successfully");
        getServletContext().getRequestDispatcher("/todo_list.jsp").forward(req, resp);
    }
}
