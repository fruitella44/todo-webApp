package com.fruitella.todo.query;


public class Queries {
    private final static String GET_ALL_TODO_BY_USER = "SELECT t FROM Todo t LEFT JOIN t.users u WHERE u.username = :USERNAME ORDER BY t.id";
    private final static String FIND_USER_BY_USERNAME = "SELECT u FROM Users u WHERE u.username = :USERNAME";

    public static String getGetAllTodoByUser() {
        return GET_ALL_TODO_BY_USER;
    }

    public static String getFindUserByUsername() {
        return FIND_USER_BY_USERNAME;
    }
}
