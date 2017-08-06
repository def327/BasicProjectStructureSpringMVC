package com.tutorial.utils;

import com.tutorial.entities.user.User;
import com.tutorial.entities.user.UserListJAXB;

import java.util.List;

/**
 * Created def327 on 8/7/17.
 */
public class UsersListJAXBCreator {

    public static UserListJAXB createUserList(List<User> users) {
        return new UserListJAXB(users);
    }
}
