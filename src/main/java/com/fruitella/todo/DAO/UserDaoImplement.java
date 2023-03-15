package com.fruitella.todo.DAO;

import com.fruitella.todo.connection.TodoAppSessionFactory;
import com.fruitella.todo.entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImplement implements UserDAO {

    @Override
    public Users getUserByUsername(String username) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Query<Users> query = session.createQuery("FROM Users WHERE username = :USERNAME", Users.class);
            query.setParameter("USERNAME", username);
            return query.uniqueResult();
        }
    }

    @Override
    public List<Users> getAllUsers() {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("FROM Users", Users.class).list();
        }
    }

    @Override
    public Users getUserById(long userId) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            return session.get(Users.class, userId);
        }
    }

    @Override
    public void addUser(Users user) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public void updateUser(Users user) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }

    @Override
    public void deleteUser(long userId) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Users user = session.get(Users.class, userId);
            session.delete(user);
            transaction.commit();
        }
    }
}
