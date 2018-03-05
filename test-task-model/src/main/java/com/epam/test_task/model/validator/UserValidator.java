package com.epam.test_task.model.validator;

import com.epam.test_task.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    private 
    public boolean supports(Class<?> aClass) {
        return false;
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;

    }
}
