package com.fruitella.todo.DAO;

import com.fruitella.todo.entity.Todo;

import java.util.List;

public interface TodoDAO {
    List<Todo> getAllTodos();
    void addTodo(Todo todo);
    void updateTodo(Todo todo);
    void deleteTodoById(long id);
    Todo getTodoById(long id);
}

