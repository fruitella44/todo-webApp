package com.fruitella.todo.DAO;

import com.fruitella.todo.connection.TodoSessionFactory;
import com.fruitella.todo.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUserByUsername(String username) {
        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE username = :USERNAME", User.class);
            query.setParameter("USERNAME", username);
            User user = query.uniqueResult();
            session.close();
            return user;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            List<User> users = session.createQuery("FROM User", User.class).list();
            return users;
        }
    }

    @Override
    public User getUserById(int userId) {
        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            User user = session.get(User.class, userId);
            return user;
        }
    }

    @Override
    public void addUser(User user) {
        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public void updateUser(User user) {
        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }

    @Override
    public void deleteUser(int userId) {
        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            session.delete(user);
            transaction.commit();
        }
    }

}
