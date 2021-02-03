package ru.vlasovmb.minprofile.business.dao.util;

import org.springframework.jdbc.core.RowMapper;
import ru.vlasovmb.minprofile.business.model.UserAccount;

public class UtilDao {

    public static final String TABLE_NAME_USER_ACCOUNT = "accounts";

    private UtilDao() {
        throw new IllegalStateException("Utility class");
    }

    public static RowMapper<UserAccount> getUserAccountRowMapper() {
        return (resultSet, i) ->
                UserAccount
                        .builder()
                        .id(resultSet.getLong("id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .balance(resultSet.getDouble("balance"))
                        .userId(resultSet.getLong("user_id"))
                        .build();
    }
}
