package com.tutorial.entities;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @Getter
    @Setter
    @NotNull
    @Size(min = 3, message = "Please use enter the login using more than 3 symbols ")
    private String login;

    @Getter
    @Setter
    @NotNull
    @Size(min = 4, max = 7, message = "Please enter the password in range from 4 to 7 symbols")
    private String password;

    @Getter
    @Setter
    private boolean keepLoggedIn;
}
