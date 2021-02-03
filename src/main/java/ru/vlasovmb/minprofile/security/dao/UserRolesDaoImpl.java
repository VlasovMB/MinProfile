package ru.vlasovmb.minprofile.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.vlasovmb.minprofile.security.dao.util.UtilDaoSecurity;
import ru.vlasovmb.minprofile.security.model.Role;
import ru.vlasovmb.minprofile.security.model.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.vlasovmb.minprofile.security.dao.util.UtilDaoSecurity.TABLE_NAME_USER_ROLES;

@Repository
public class UserRolesDaoImpl implements UserRolesDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleInsert;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleInsert =
                new SimpleJdbcInsert(dataSource)
                        .withTableName(TABLE_NAME_USER_ROLES)
                        .usingGeneratedKeyColumns("id");
    }

    @Override
    public User addUserRole(User user, Role role) {
        final Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("user_id", user.getId());
        parameters.put("role_id", role.getId());
        simpleInsert.executeAndReturnKey(parameters);
        return user;
    }

    @Override
    public Iterable<Role> getUserRoles(User user) {
        final SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
                user
        );
        final String SQL_STRING =
                "SELECT role_id as id, roles.name \n" +
                        "FROM user_roles \n" +
                        "JOIN roles ON role_id = roles.id \n" +
                        "WHERE user_id = :id";
        return namedParameterJdbcTemplate
                .queryForStream(
                        SQL_STRING,
                        namedParameters,
                        UtilDaoSecurity.getRoleRowMapper()
                )
                .collect(Collectors.toList());
    }
}
