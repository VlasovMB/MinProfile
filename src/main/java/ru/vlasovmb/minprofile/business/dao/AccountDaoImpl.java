package ru.vlasovmb.minprofile.business.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import ru.vlasovmb.minprofile.business.model.UserAccount;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static ru.vlasovmb.minprofile.business.dao.util.UtilDao.TABLE_NAME_USER_ACCOUNT;
import static ru.vlasovmb.minprofile.business.dao.util.UtilDao.getUserAccountRowMapper;

@Service
public class AccountDaoImpl implements AccountDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleInsert;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME_USER_ACCOUNT).usingGeneratedKeyColumns("id");
    }

    public UserAccount save(UserAccount userAccount) {
        final Map<String, Object> parameters = new HashMap<>(4);
        parameters.put("first_name", userAccount.getFirstName());
        parameters.put("last_name", userAccount.getLastName());
        parameters.put("balance", userAccount.getBalance());
        parameters.put("user_id", userAccount.getUserId());
        try{
            Number newId = simpleInsert.executeAndReturnKey(parameters);
            userAccount.setId(newId.longValue());
            return userAccount;
        } catch (InvalidDataAccessApiUsageException invalidDataAccessApiUsageException){
            return userAccount;
        }


    }

    public UserAccount findById(Long id) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate
                .queryForObject(
                        "SELECT * FROM " + TABLE_NAME_USER_ACCOUNT + " WHERE id = :id",
                        namedParameters, getUserAccountRowMapper());
    }

    @Override
    public UserAccount findByUsername(String username) {
        if (username==null) return null;
        System.out.println(username);
        final String SQL_STRING = "SELECT * \n" +
                "FROM accounts\n" +
                "JOIN users ON user_id=users.id \n" +
                "WHERE users.username = :username";
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("username", username);
        return namedParameterJdbcTemplate
                .queryForObject(SQL_STRING, namedParameters, getUserAccountRowMapper());
    }
}
