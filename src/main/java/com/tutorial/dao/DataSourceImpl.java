package com.tutorial.dao;

import com.tutorial.entities.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@Repository
public class DataSourceImpl implements DataSource {

    @Resource(name = "userInitDBMock")
    private List<User> users;

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public User getUserById(BigInteger userIdToFind) {
        return users.stream().filter(user -> user.getUserId().equals(userIdToFind)).findFirst().orElseGet(null);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
