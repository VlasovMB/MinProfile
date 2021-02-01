package ru.vlasovmb.minprofile.security.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.vlasovmb.minprofile.security.model.User;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
