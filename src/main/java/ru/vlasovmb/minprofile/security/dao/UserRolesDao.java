package ru.vlasovmb.minprofile.security.dao;

import ru.vlasovmb.minprofile.security.model.Role;
import ru.vlasovmb.minprofile.security.model.User;

public interface UserRolesDao {
    User addUserRole(User user, Role role);

    Iterable<Role> getUserRoles(User user);
}
