package ru.vlasovmb.minprofile.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {
    private Long id;
    private String username;
    private String password;
    transient private String passwordConfirm;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
