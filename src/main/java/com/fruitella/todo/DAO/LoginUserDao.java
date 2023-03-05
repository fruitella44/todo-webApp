package com.fruitella.todo.DAO;

import com.fruitella.todo.connection.TodoAppSessionFactory;
import com.fruitella.todo.entity.Users;
import com.fruitella.todo.hasher.PasswordHasher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

public class LoginUserDao {


    public boolean validate(String name, String password) {
        Transaction transaction = null;

        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<Users> userQuery = session.createQuery("FROM Users WHERE username = :NAME");
            userQuery.setParameter("NAME", name);

            Users user = userQuery.getSingleResult();
            transaction.commit();

            if (user != null && PasswordHasher.checkPassword(password, user.getUserPassword())) {
                return true;
            } else {
                return false;
            }


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            return false;
        }
    }

}
