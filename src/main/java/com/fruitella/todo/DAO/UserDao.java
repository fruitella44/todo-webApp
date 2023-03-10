package com.fruitella.todo.DAO;

import com.fruitella.todo.entity.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    User getUserById(int userId);

    User getUserByUsername(String username);

    List<User> getAllUsers();

}
