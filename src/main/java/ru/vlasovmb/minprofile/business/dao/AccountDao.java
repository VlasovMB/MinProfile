package ru.vlasovmb.minprofile.business.dao;

import ru.vlasovmb.minprofile.business.model.UserAccount;

public interface AccountDao {
    UserAccount save(UserAccount userAccount);

    UserAccount findById(Long id);

    UserAccount findByUsername(String username);
}
