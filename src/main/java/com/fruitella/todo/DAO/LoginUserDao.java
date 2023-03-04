package com.fruitella.todo.DAO;

import com.fruitella.todo.connection.TodoAppSessionFactory;
import com.fruitella.todo.entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LoginUserDao {

    public boolean validate(String name, String password) {
        Transaction transaction = null;

        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<Users> userQuery = session.createQuery("FROM Users WHERE username = :NAME AND userPassword = :PASSWORD");
            userQuery.setParameter("NAME", name);
            userQuery.setParameter("PASSWORD", password);

            List<Users> users = userQuery.list();
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
