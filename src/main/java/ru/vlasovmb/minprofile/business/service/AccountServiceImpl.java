package ru.vlasovmb.minprofile.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlasovmb.minprofile.business.dao.AccountDao;
import ru.vlasovmb.minprofile.business.model.UserAccount;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return accountDao.save(userAccount);
    }

    @Override
    public UserAccount findById(Long accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public UserAccount findByUsername(String username) {
        return accountDao.findByUsername(username);
    }
}
