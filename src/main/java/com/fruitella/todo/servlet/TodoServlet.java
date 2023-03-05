package com.fruitella.todo.servlet;

import com.fruitella.todo.DAO.TodoDaoImplement;
import com.fruitella.todo.entity.Todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
    private TodoDaoImplement todoDao;

    public TodoServlet() {;
        todoDao = new TodoDaoImplement();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new" -> showNewForm(request, response);
            case "/insert" -> insertTodo(request, response);
            case "/delete" -> deleteTodo(request, response);
            case "/edit" -> showEditForm(request, response);
            case "/update" -> updateTodo(request, response);
            default -> listTodo(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    private void listTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Todo> todoList = todoDao.getAllTodos();
        request.setAttribute("todoList", todoList);
        request.getRequestDispatcher("todo_list.jsp").forward(request, response);
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("todo_form.jsp").forward(request, response);
    }

    private void insertTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime createdDate = LocalDateTime.now();
        LocalDateTime expiredDate = LocalDateTime.parse(request.getParameter("expiredDate"), formatter);

        Todo todo = Todo.builder()
                .username(username)
                .title(title)
                .description(description)
                .isDone(isDone)
                .createdDate(createdDate)
                .expiredDate(expiredDate)
                .build();

        todoDao.addTodo(todo);
        response.sendRedirect("list");
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Todo existingTodo = todoDao.getTodoById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo_form.jsp");
        request.setAttribute("todo", existingTodo);
        dispatcher.forward(request, response);
    }

    private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        LocalDateTime createdDate = LocalDateTime.now().parse(request.getParameter("createdDate"));
        LocalDateTime expiredDate = LocalDateTime.parse(request.getParameter("expiredDate"));

        Todo todo = Todo.builder()
                .username(username)
                .title(title)
                .description(description)
                .isDone(isDone)
                .createdDate(createdDate)
                .expiredDate(expiredDate)
                .build();

        todoDao.updateTodo(todo);
        response.sendRedirect("list");
    }

    private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        todoDao.deleteTodoById(id);
        response.sendRedirect("list");
    }

}

