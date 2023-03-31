package com.fruitella.todo.service;

import com.fruitella.todo.DAO.UserDaoImplement;
import com.fruitella.todo.entity.Users;

public class UserService {
    private static final UserDaoImplement userDao;

    static {
        userDao = new UserDaoImplement();
    }

    public void addUser(Users user) {
        userDao.addUser(user);
    }

    public Users getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
