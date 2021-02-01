package ru.vlasovmb.minprofile.security.service;

import ru.vlasovmb.minprofile.security.model.User;

public interface UserService {

    User save(User user);

    User findByUsername(String username);
}
