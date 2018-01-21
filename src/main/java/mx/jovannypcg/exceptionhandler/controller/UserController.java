package mx.jovannypcg.exceptionhandler.controller;

import mx.jovannypcg.exceptionhandler.controller.exception.UserNotFoundException;
import mx.jovannypcg.exceptionhandler.domain.ApiError;
import mx.jovannypcg.exceptionhandler.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{username}")
    public ResponseEntity<User> get(@PathVariable String username) throws UserNotFoundException {
        // More logic on User

        throw UserNotFoundException.createWith(username);
    }
}
