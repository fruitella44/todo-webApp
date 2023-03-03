package com.fruitella.todo.DAO;

import java.util.List;

import com.fruitella.todo.connection.TodoSessionFactory;
import com.fruitella.todo.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TodoUserDao implements UserDao {

    @Override
    public void addUser(User user) {
        Transaction transaction = null;

        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = null;

        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteUser(int userId) {
        Transaction transaction = null;

        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, userId);

            if (user != null) {
                session.delete(user);
                transaction.commit();
            }
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public User getUserById(int userId) {
        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            return session.get(User.class, userId);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE username=:USERNAME", User.class);
            query.setParameter("USERNAME", username);
            return query.uniqueResult();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            Query<User> getAll = session.createQuery("FROM User", User.class);
            return getAll.getResultList();
        }
    }

}
