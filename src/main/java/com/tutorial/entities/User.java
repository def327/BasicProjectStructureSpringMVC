package com.tutorial.entities;


import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private boolean keepLoggedIn;
}
