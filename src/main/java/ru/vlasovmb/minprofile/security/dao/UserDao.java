package ru.vlasovmb.minprofile.security.dao;

import ru.vlasovmb.minprofile.security.model.User;

import java.util.Optional;

public interface UserDao {

    User save(User user);

    Optional<User> findById(Long userId);

    User findByName(String username);

    boolean existsById(Long userId);


}
