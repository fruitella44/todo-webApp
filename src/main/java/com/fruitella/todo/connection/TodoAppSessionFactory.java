package com.fruitella.todo.connection;

import com.fruitella.todo.entity.Todo;
import com.fruitella.todo.entity.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TodoAppSessionFactory {
    private static final Logger LOGGER = LogManager.getLogger(TodoAppSessionFactory.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Users.class);
            configuration.addAnnotatedClass(Todo.class);
            configuration.configure();

            LOGGER.debug("Created initial sessionFactory: [Users, Todo]");
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            LOGGER.debug("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
