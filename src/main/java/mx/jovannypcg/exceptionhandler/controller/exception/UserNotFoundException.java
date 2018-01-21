package mx.jovannypcg.exceptionhandler.controller.exception;

import mx.jovannypcg.exceptionhandler.domain.User;

public class UserNotFoundException extends Exception {
    private String username;

    public static UserNotFoundException createWith(String username) {
        return new UserNotFoundException(username);
    }

    private UserNotFoundException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return "User '" + username + "' not found";
    }
}
