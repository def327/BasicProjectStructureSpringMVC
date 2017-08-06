package com.tutorial.dao;

import com.tutorial.entities.user.User;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@Repository
public class DataSourceImpl implements DataSource {

    @Setter
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
        User user = users.stream().filter(o -> o.getUserId().equals(userIdToFind)).findFirst().get();
        return user;
    }
}
