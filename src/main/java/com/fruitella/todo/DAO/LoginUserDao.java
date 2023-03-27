package com.fruitella.todo.DAO;

import com.fruitella.todo.connection.TodoAppSessionFactory;
import com.fruitella.todo.entity.Users;
import com.fruitella.todo.hasher.PasswordHasher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class LoginUserDao {

    private static final Logger LOGGER = LogManager.getLogger(LoginUserDao.class);

    public boolean validate(String name, String password) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Users> userQuery = session.createQuery("FROM Users WHERE username = :NAME");
            userQuery.setParameter("NAME", name);
            LOGGER.debug("Select user from table users. Found: " + name);

            Users user = userQuery.getSingleResult();

            if (user != null && PasswordHasher.checkPassword(password, user.getUserPassword())) {
                transaction.commit();
                LOGGER.debug("Encrypted password correct");
                return true;
            } else {
                transaction.rollback();
                LOGGER.debug("Encrypted password not correct");
                return false;
            }

        } catch (Exception ex) {
            LOGGER.error("Cannot validate this user: " + name + ". Trace: " + ex);
            return false;
        }
    }

}
