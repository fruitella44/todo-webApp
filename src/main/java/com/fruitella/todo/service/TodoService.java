package com.fruitella.todo.service;

import com.fruitella.todo.DAO.TodoDaoImplement;
import com.fruitella.todo.entity.Todo;

import java.util.List;

public class TodoService {
    private static final TodoDaoImplement todoDao;

    static {
        todoDao = new TodoDaoImplement();
    }

    public List<Todo> getAllTodos(String username) {
        return todoDao.getAllTodos(username);
    }

    public void addTodo(Todo todo) {
        todoDao.addTodo(todo);
    }

    public void updateTodo(Todo todo) {
        todoDao.updateTodo(todo);
    }

    public void deleteTodoById(long id) {
        todoDao.deleteTodoById(id);
    }

    public Todo getTodoById(long id) {
        return todoDao.getTodoById(id);
    }
}
