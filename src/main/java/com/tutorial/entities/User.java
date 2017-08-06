package com.tutorial.entities;


import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

public class User {

    @Getter
    @Setter
    private BigInteger userId;

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
