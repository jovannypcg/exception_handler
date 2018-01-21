package mx.jovannypcg.exceptionhandler.common;

import mx.jovannypcg.exceptionhandler.domain.Containable;
import org.springframework.validation.ObjectError;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContentUtils {
    private static final List<String> NOT_ALLOWED_WORDS = Arrays.asList(
            "politics",
            "terrorism",
            "murder"
    );

    public static List<ObjectError> getContentErrorsFrom(Containable containable) {
        return Arrays.stream(containable.getContent().split("\\s"))
                .filter(NOT_ALLOWED_WORDS::contains)
                .map(notAllowedWord -> new ObjectError(notAllowedWord, "is not appropriate"))
                .collect(Collectors.toList());
    }
}
