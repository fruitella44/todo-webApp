package com.fruitella.todo.hasher;

import com.fruitella.todo.entity.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    private static final Logger LOGGER = LogManager.getLogger(PasswordHasher.class);
    private static final Users users = new Users();
    public static String hashPassword(String password) {
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        users.setUserPassword(passwordHash);
        LOGGER.debug("Encrypt password");
        return passwordHash;
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        LOGGER.debug("Checked encrypted password");
        return BCrypt.checkpw(password, hashedPassword);
    }
}
