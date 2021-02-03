package ru.vlasovmb.minprofile.business.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccount {

    private Long id;
    private String firstName;
    private String lastName;
    private Double balance;
    private Long userId;
}
