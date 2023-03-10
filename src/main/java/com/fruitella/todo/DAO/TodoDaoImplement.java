package com.fruitella.todo.DAO;

import java.util.List;

import com.fruitella.todo.connection.TodoAppSessionFactory;
import com.fruitella.todo.entity.Todo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TodoDaoImplement implements TodoDAO {

    @Override
    public List<Todo> getAllTodos() {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Query<Todo> todoQuery = session.createQuery("FROM Todo", Todo.class);
            return todoQuery.getResultList();
        }
    }

    @Override
    public void addTodo(Todo todo) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(todo);
            transaction.commit();
        }
    }

    @Override
    public void updateTodo(Todo todo) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(todo);
            transaction.commit();
        }
    }

    @Override
    public void deleteTodoById(long id) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Todo todo = session.load(Todo.class, id);
            if (todo != null) {
                session.delete(todo);
                transaction.commit();
            }
        }
    }

    @Override
    public Todo getTodoById(long todoId) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Todo todo = session.get(Todo.class, todoId);
            transaction.commit();
            return todo;
        }
    }
}
