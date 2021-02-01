package ru.vlasovmb.minprofile.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.vlasovmb.minprofile.security.model.Role;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static ru.vlasovmb.minprofile.security.dao.util.UtilDaoSecurity.TABLE_NAME_ROLES;
import static ru.vlasovmb.minprofile.security.dao.util.UtilDaoSecurity.getRoleRowMapper;

@Repository
public class RoleDaoImpl implements RoleDao {


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleInsert;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME_ROLES).usingGeneratedKeyColumns("id");
    }

    @Override
    public Role save(Role role) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("name", role.getName().toLowerCase());
        Number newId = simpleInsert.executeAndReturnKey(parameters);
        role.setId(newId.longValue());
        return role;
    }

    @Override
    public Optional<Role> findById(Long roleId) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", roleId);
        return Optional.ofNullable(namedParameterJdbcTemplate
                .queryForObject("SELECT * FROM "+TABLE_NAME_ROLES+" WHERE id = :id", namedParameters, getRoleRowMapper()));
    }

    @Override
    public Optional<Role> findByName(String roleName) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", roleName.toLowerCase());
        return Optional.ofNullable(namedParameterJdbcTemplate
                .queryForObject("SELECT * FROM "+TABLE_NAME_ROLES+" WHERE name = :name", namedParameters, getRoleRowMapper()));
    }

    @Override
    public boolean existsById(Long roleId) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", roleId);
        return namedParameterJdbcTemplate
                .queryForObject("SELECT EXISTS(SELECT id FROM "+TABLE_NAME_ROLES+" WHERE id = :id)", namedParameters, Boolean.class);

    }

}
