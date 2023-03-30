package com.fruitella.todo.service;

import com.fruitella.todo.entity.Todo;

import java.util.List;

public interface ITodoService {
    List<Todo> getAllTodos(String username);
    void addTodo(Todo todo);
    void updateTodo(Todo todo);
    void deleteTodoById(long id);
    Todo getTodoById(long id);
}
