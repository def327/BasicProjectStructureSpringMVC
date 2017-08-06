package com.tutorial.dao;

import com.tutorial.entities.User;

import java.math.BigInteger;
import java.util.List;

public interface DataSource {

    List<User> getUsers();

    void addUser(User user);

    User getUserById(BigInteger userIdToFind);

}
