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

    public UserForm(String username,
                    String password,
                    String passwordConfirm,
                    String firstName,
                    String lastName) {
        this.user =
                User.builder()
                        .username(username)
                        .password(password)
                        .passwordConfirm(passwordConfirm)
                        .build();
        this.userAccount =
                UserAccount.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .build();
    }


}
