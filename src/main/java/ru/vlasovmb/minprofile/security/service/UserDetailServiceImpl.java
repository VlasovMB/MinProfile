package ru.vlasovmb.minprofile.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlasovmb.minprofile.security.dao.UserDao;
import ru.vlasovmb.minprofile.security.dao.UserRolesDao;
import ru.vlasovmb.minprofile.security.model.User;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDao userDao;
    private final UserRolesDao userRolesDao;

    @Autowired
    public UserDetailServiceImpl(UserDao userDao, UserRolesDao userRolesDao) {
        this.userDao = userDao;
        this.userRolesDao = userRolesDao;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDao.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    StreamSupport
                            .stream(userRolesDao.getUserRoles(user).spliterator(), false)
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toSet())
            );
        }
    }
}
