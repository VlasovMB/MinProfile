package ru.vlasovmb.minprofile.security.dao;

import ru.vlasovmb.minprofile.security.model.Role;

import java.util.Optional;

public interface RoleDao {

    Role save(Role role);

    Optional<Role> findById(Long roleId);

    Optional<Role> findByName(String roleName);

    boolean existsById(Long roleId);

}
