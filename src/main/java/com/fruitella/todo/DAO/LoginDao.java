package com.fruitella.todo.DAO;

import com.fruitella.todo.connection.TodoSessionFactory;
import com.fruitella.todo.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LoginDao {

    public boolean validate(String name, String password) {
        Transaction transaction = null;

        try (Session session = TodoSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<User> userQuery = session.createQuery("FROM User WHERE username = :NAME AND userPassword = :PASSWORD");
            userQuery.setParameter("NAME", name);
            userQuery.setParameter("PASSWORD", password);

            List<User> users = userQuery.list();
            transaction.commit();

            return !users.isEmpty();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            return false;
        }
    }
}
