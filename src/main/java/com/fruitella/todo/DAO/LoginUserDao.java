package com.fruitella.todo.DAO;

import com.fruitella.todo.connection.TodoAppSessionFactory;
import com.fruitella.todo.entity.Users;
import com.fruitella.todo.hasher.PasswordHasher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class LoginUserDao {


    public boolean validate(String name, String password) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Users> userQuery = session.createQuery("FROM Users WHERE username = :NAME");
            userQuery.setParameter("NAME", name);

            Users user = userQuery.getSingleResult();

            if (user != null && PasswordHasher.checkPassword(password, user.getUserPassword())) {
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

}
