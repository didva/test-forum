package com.dmytro.mudrov.forum.server.dao;

import com.dmytro.mudrov.forum.server.model.User;

public interface UserDao {

    long saveOrUpdate(User user);

    User findByName(String name);

    User find(long id);

}
