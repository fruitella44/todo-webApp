package com.fruitella.todo.service;

import com.fruitella.todo.DAO.TodoDaoImplement;
import com.fruitella.todo.entity.Todo;

import java.util.List;

public class TodoService implements ITodoService {
    private static final TodoDaoImplement todoDao;

    static {
        todoDao = new TodoDaoImplement();
    }

    @Override
    public List<Todo> getAllTodos(String username) {
        return todoDao.getAllTodos(username);
    }

    @Override
    public void addTodo(Todo todo) {
        todoDao.addTodo(todo);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoDao.updateTodo(todo);
    }

    @Override
    public void deleteTodoById(long id) {
        todoDao.deleteTodoById(id);
    }

    @Override
    public Todo getTodoById(long id) {
        return todoDao.getTodoById(id);
    }
}
