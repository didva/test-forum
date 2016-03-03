package com.dmytro.mudrov.forum.server.dao.inmemmory;

import com.dmytro.mudrov.forum.server.dao.UserDao;
import com.dmytro.mudrov.forum.server.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private static long id = 0;
    private Map<String, User> userMap = new HashMap<>();

    @Override
    public synchronized long saveOrUpdate(User user) {
        if (user.getId() == 0) {
            user.setId(++id);
        }
        userMap.put(user.getName(), user);
        return user.getId();
    }

    @Override
    public User findByName(String name) {
        return userMap.get(name);
    }

    @Override
    public User find(long id) {
        return userMap.values().stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }
}
