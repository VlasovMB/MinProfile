package ru.vlasovmb.minprofile.security.dao.util;

import org.springframework.jdbc.core.RowMapper;
import ru.vlasovmb.minprofile.security.model.Role;
import ru.vlasovmb.minprofile.security.model.User;

public class UtilDaoSecurity {

    public static final String TABLE_NAME_USER_ROLES = "user_roles";
    public static final String TABLE_NAME_USERS = "users";
    public static final String TABLE_NAME_ROLES = "roles";

    private UtilDaoSecurity() {
        throw new IllegalStateException("Utility class");
    }

    public static RowMapper<User> getUserRowMapper() {
        return (resultSet, i) ->
                User
                        .builder()
                        .id(resultSet.getLong("id"))
                        .username(resultSet.getString("username"))
                        .password(resultSet.getString("password"))
                        .build();
    }

    public static RowMapper<Role> getRoleRowMapper() {
        return (resultSet, i) ->
                Role
                        .builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .build();
    }
}
