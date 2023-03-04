package com.fruitella.todo.DAO;

import com.fruitella.todo.entity.Users;

import java.util.List;

public interface UserDAO {

    void addUser(Users user);

    void updateUser(Users user);

    void deleteUser(int userId);

    Users getUserById(int userId);

    Users getUserByUsername(String username);

    List<Users> getAllUsers();
}
