package mx.jovannypcg.exceptionhandler.controller;

import mx.jovannypcg.exceptionhandler.common.ContentUtils;
import mx.jovannypcg.exceptionhandler.controller.exception.ContentNotAllowedException;
import mx.jovannypcg.exceptionhandler.domain.ApiError;
import mx.jovannypcg.exceptionhandler.domain.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users/{username}/posts")
public class PostController {


    @PostMapping
    public ResponseEntity<Post> create(@PathVariable String username, @RequestBody Post post)
            throws ContentNotAllowedException {
        List<ObjectError> contentNotAllowedErrors = ContentUtils.getContentErrorsFrom(post);

        if (!contentNotAllowedErrors.isEmpty()) {
            throw ContentNotAllowedException.createWith(contentNotAllowedErrors);
        }

        // More logic on Post

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
