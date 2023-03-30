package com.fruitella.todo.service;

import com.fruitella.todo.entity.Users;

import java.util.List;

public interface IUserService {
    void addUser(Users user);

    void updateUser(Users user);

    void deleteUser(long userId);

    Users getUserById(long userId);

    Users getUserByUsername(String username);

    List<Users> getAllUsers();
}
