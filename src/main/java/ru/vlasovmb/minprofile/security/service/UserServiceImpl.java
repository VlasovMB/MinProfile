package ru.vlasovmb.minprofile.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlasovmb.minprofile.security.dao.RoleDao;
import ru.vlasovmb.minprofile.security.dao.UserDao;
import ru.vlasovmb.minprofile.security.dao.UserRolesDao;
import ru.vlasovmb.minprofile.security.model.Role;
import ru.vlasovmb.minprofile.security.model.User;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserRolesDao userRolesDao;
    private final RoleDao roleDao;


    @Autowired
    public UserServiceImpl(UserDao userDao, UserRolesDao userRolesDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.userRolesDao = userRolesDao;
        this.roleDao = roleDao;
    }

    @Override
    public User save(User user) {
        Role userRole =
                roleDao.findByName("role_user".toLowerCase())
                .orElseGet(()->
                        roleDao.save(Role.builder()
                                .name("role_user".toLowerCase())
                                .build()));
        User newUser = userDao.save(user);
        userRolesDao.addUserRole(newUser, userRole);
        return newUser;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByName(username);
    }
}
