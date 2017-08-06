package com.tutorial.entities.user;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigInteger;

@XmlRootElement(name = "user")
@XmlType(propOrder = {"userId", "login", "password"})
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class User implements Serializable {

    @XmlElement(name = "id")
    private BigInteger userId;

    private String login;

    @XmlElement
    private String password;

    @XmlAttribute
    private boolean keepLoggedIn;
}
