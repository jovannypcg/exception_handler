package mx.jovannypcg.exceptionhandler.controller.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

public class ContentNotAllowedException extends Exception {
    List<ObjectError> errors;

    public static ContentNotAllowedException createWith(List<ObjectError> errors) {
        return new ContentNotAllowedException(errors);
    }

    private ContentNotAllowedException(List<ObjectError> errors) {
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }
}
