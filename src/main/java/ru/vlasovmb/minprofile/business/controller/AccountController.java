package ru.vlasovmb.minprofile.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vlasovmb.minprofile.business.model.UserAccount;
import ru.vlasovmb.minprofile.business.service.AccountService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/balance")
    public String balancePage(
            Model model,
            HttpServletRequest httpServletRequest
    ) {
        UserAccount userAccount = accountService.findByUsername(
                httpServletRequest.getUserPrincipal().getName()
        );
        model.addAttribute("account", userAccount);
        return "balance";
    }
}
