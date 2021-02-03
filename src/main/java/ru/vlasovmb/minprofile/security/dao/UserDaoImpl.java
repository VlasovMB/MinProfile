package ru.vlasovmb.minprofile.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.vlasovmb.minprofile.security.model.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static ru.vlasovmb.minprofile.security.dao.util.UtilDaoSecurity.TABLE_NAME_USERS;
import static ru.vlasovmb.minprofile.security.dao.util.UtilDaoSecurity.getUserRowMapper;

@Repository
public class UserDaoImpl implements UserDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleInsert;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleInsert =
                new SimpleJdbcInsert(dataSource)
                        .withTableName(TABLE_NAME_USERS)
                        .usingGeneratedKeyColumns("id");
    }

    @Override
    public User save(User user) {
        final Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("username", user.getUsername().toLowerCase());
        parameters.put("password", user.getPassword());
        try {
            Number newId = simpleInsert.executeAndReturnKey(parameters);
            user.setId(newId.longValue());
            return user;
        } catch (
                InvalidDataAccessApiUsageException invalidDataAccessApiUsageException
        ) {
            return user;
        }
    }

    @Override
    public Optional<User> findById(Long userId) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", userId);
        return Optional.ofNullable(
                namedParameterJdbcTemplate.queryForObject(
                        "SELECT * FROM " + TABLE_NAME_USERS + " WHERE id = :id",
                        namedParameters,
                        getUserRowMapper()
                )
        );
    }

    @Override
    public User findByName(String username) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("username", username.toLowerCase());
        User user;
        try {
            user =
                    namedParameterJdbcTemplate.queryForObject(
                            "SELECT * FROM " + TABLE_NAME_USERS + " WHERE username = :username",
                            namedParameters,
                            getUserRowMapper()
                    );
        } catch (Exception ignored) {
            return null;
        }
        return user;
    }

    @Override
    public boolean existsById(Long userId) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", userId);
        return namedParameterJdbcTemplate.queryForObject(
                "SELECT EXISTS(SELECT id FROM " + TABLE_NAME_USERS + " WHERE id = :id)",
                namedParameters,
                Boolean.class
        );
    }
}
