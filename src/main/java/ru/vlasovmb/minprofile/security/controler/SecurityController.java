package ru.vlasovmb.minprofile.security.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vlasovmb.minprofile.business.model.UserAccount;
import ru.vlasovmb.minprofile.business.service.AccountService;
import ru.vlasovmb.minprofile.security.model.User;
import ru.vlasovmb.minprofile.security.model.UserForm;
import ru.vlasovmb.minprofile.security.service.SecurityService;
import ru.vlasovmb.minprofile.security.service.UserService;
import ru.vlasovmb.minprofile.security.validator.UserValidator;

@Controller
public class SecurityController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final SecurityService securityService;
    private final AccountService accountService;

    @Autowired
    public SecurityController(
            UserService userService,
            UserValidator userValidator,
            SecurityService securityService,
            AccountService accountService
    ) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.securityService = securityService;
        this.accountService = accountService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(
            @ModelAttribute("userForm") UserForm userForm,
            BindingResult bindingResult
    ) {
        userValidator.validate(userForm.getUser(), bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User newUser = userService.save(userForm.getUser());
        UserAccount userAccount = userForm.getUserAccount();
        userAccount.setUserId(newUser.getId());
        userAccount.setBalance(0.);
        accountService.save(userAccount);
        securityService.autoLogin(
                newUser.getUsername(),
                newUser.getPasswordConfirm()
        ); //password confirm raw, specially for autologin
        return "redirect:/balance";
    }

    @GetMapping("/login")
    public String loginPage(Model model, String error, String logout) {
        if (!securityService.isAnonymousUser()) return "redirect:/balance";
        if (error != null) {
            model.addAttribute("error", "Пользователь или пароль не верный");
        }
        if (logout != null) {
            model.addAttribute("message", "Выход успешен");
        }

        return "login";
    }

    @GetMapping("/error403")
    public String error403(Model model) {
        return "error403";
    }
}
