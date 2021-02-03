package ru.vlasovmb.minprofile.security.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.vlasovmb.minprofile.security.model.User;
import ru.vlasovmb.minprofile.security.service.UserService;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors,
                "user.username",
                "Required"
        );

        if (user.getUsername().length() < 3 || user.getUsername().length() > 30) {
            errors.rejectValue("user.username", "Size.userForm.user.username");
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("user.username", "Duplicate.userForm.user.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors,
                "user.password",
                "Required"
        );
        if (user.getPassword().length() < 3 || user.getPassword().length() > 30) {
            errors.rejectValue("user.password", "Size.userForm.user.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue(
                    "user.passwordConfirm",
                    "Different.userForm.user.password"
            );
        }
    }
}
