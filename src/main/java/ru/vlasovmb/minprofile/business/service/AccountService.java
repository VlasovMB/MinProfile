package ru.vlasovmb.minprofile.business.service;

import ru.vlasovmb.minprofile.business.model.UserAccount;

public interface AccountService {
    UserAccount save(UserAccount userAccount);

    UserAccount findById(Long accountId);

    UserAccount findByUsername(String username);
}
