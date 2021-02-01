package ru.vlasovmb.minprofile.controller;

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


@Controller
public class AppController {

    private final SecurityService securityService;
    private final UserService userService;
    private final AccountService accountService;

    @Autowired
    public AppController(SecurityService securityService,
                         UserService userService,
                         AccountService accountService) {
        this.securityService = securityService;
        this.userService = userService;
        this.accountService = accountService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult) {
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
                newUser.getPassword());
        return "redirect:/balance";

    }

    @GetMapping("/balance")
    public String balancePage(Model model) {
        UserAccount userAccount = accountService.findByUsername(securityService.getCurrentUsername());
        model.addAttribute("account", userAccount);
        return "balance";
    }


	@GetMapping("/login")
	public String loginPage(Model model, String error, String logout)  {
        if (error !=null) {
            model.addAttribute("error", "Пользователь или пароль не верный");
        }
        if (logout != null) {
            model.addAttribute("message", "Выход успешен");
        }

		return "login";
	}

	@GetMapping("/")
    public String home(Model model){
        return "redirect:/balance";
    }
}