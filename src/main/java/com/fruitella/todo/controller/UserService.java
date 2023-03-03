package com.fruitella.todo.controller;

import com.fruitella.todo.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int userId);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

}
