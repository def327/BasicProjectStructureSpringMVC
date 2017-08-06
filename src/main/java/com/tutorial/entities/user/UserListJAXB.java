package com.tutorial.entities.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "users")
@XmlSeeAlso(User.class)
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class UserListJAXB implements Serializable {

    private List<User> users;
}
