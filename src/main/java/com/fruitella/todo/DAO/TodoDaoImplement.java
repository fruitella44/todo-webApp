package com.fruitella.todo.DAO;

import java.util.List;

import com.fruitella.todo.connection.TodoAppSessionFactory;
import com.fruitella.todo.entity.Todo;
import com.fruitella.todo.query.Queries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TodoDaoImplement implements TodoDAO {

    private static final Logger LOGGER = LogManager.getLogger(TodoDaoImplement.class);
    @Override
    public List<Todo> getAllTodos(String username) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Todo> todoQuery = session.createQuery(Queries.getGetAllTodoByUser(), Todo.class);
            todoQuery.setParameter("USERNAME", username);
            List<Todo> todoList = todoQuery.getResultList();
            transaction.commit();

            LOGGER.debug("Select all tasks from table todos: " + todoList.size());
            return todoList;

        }
    }

    @Override
    public void addTodo(Todo todo) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(todo);
            transaction.commit();
            LOGGER.debug("Insert new task to table todos: " + todo.getId());
        }
    }

    @Override
    public void updateTodo(Todo todo) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(todo);
            transaction.commit();
            LOGGER.debug("Update existed task from table todos: " + todo.getId());
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
                LOGGER.debug("Delete existed task from table todos: " + id);
            }
        }
    }

    @Override
    public Todo getTodoById(long todoId) {
        try (Session session = TodoAppSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Todo todo = session.get(Todo.class, todoId);
            transaction.commit();

            LOGGER.debug("Found todo by id: " + todoId);
            return todo;
        }
    }

}
