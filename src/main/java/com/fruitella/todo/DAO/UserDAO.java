package com.fruitella.todo.DAO;

import com.fruitella.todo.entity.Users;

import java.util.List;

public interface UserDAO {

    void addUser(Users user);

    void updateUser(Users user);

    void deleteUser(long userId);

    Users getUserById(long userId);

    Users getUserByUsername(String username);

    List<Users> getAllUsers();
}
