package com.fruitella.todo.connection;

import com.fruitella.todo.entity.Todo;
import com.fruitella.todo.entity.Users;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TodoAppSessionFactory {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Users.class);
            configuration.addAnnotatedClass(Todo.class);
            configuration.configure();
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
