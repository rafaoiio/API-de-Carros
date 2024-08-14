package br.com.RafaG.apidecarros.utils;

import java.util.Set;
 
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
 
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
 
public class ValidationUtil {
 
    public static <T> void validate(final T object) {
 
        final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        final Validator validator = validatorFactory.getValidator();
 
        final StringBuilder validationErrors = new StringBuilder();
        final Set<ConstraintViolation<T>> validate = validator.validate(object);
 
        validate.forEach(v -> {
            validationErrors.append(v.getMessage() + "\n");
        });
 
        if (validationErrors.length() > 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, validationErrors.toString());
        }
    }
 
}