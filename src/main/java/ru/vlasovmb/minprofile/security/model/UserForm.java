package ru.vlasovmb.minprofile.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vlasovmb.minprofile.business.model.UserAccount;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {

    User user;
    UserAccount userAccount;
}
