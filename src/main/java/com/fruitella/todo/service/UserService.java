package com.fruitella.todo.service;

import com.fruitella.todo.DAO.UserDaoImplement;
import com.fruitella.todo.entity.Users;

import java.util.List;

public class UserService implements IUserService{
    private static final UserDaoImplement userDao;

    static {
        userDao = new UserDaoImplement();
    }

    @Override
    public void addUser(Users user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(Users user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public Users getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Users getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }
}
