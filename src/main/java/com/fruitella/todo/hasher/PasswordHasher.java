package com.fruitella.todo.hasher;

import com.fruitella.todo.entity.Users;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    private static final Users users = new Users();
    public static String hashPassword(String password) {
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        users.setUserPassword(passwordHash);
        return passwordHash;
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        boolean checkPassword = BCrypt.checkpw(password, hashedPassword);
        return checkPassword;
    }
}

