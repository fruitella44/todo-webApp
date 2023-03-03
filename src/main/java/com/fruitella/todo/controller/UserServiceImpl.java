package com.fruitella.todo.controller;

import com.fruitella.todo.DAO.UserDao;
import com.fruitella.todo.DAO.UserDaoImpl;
import com.fruitella.todo.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl(); // initialize the UserDao
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

}
