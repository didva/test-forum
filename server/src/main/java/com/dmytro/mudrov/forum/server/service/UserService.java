package com.dmytro.mudrov.forum.server.service;

import com.dmytro.mudrov.forum.dto.user.UserDTO;
import com.dmytro.mudrov.forum.server.dao.UserDao;
import com.dmytro.mudrov.forum.server.model.User;

public class UserService {

    private UserDao userDao;

    public User findUser(long id) {
        return userDao.find(id);
    }

    public User saveOrUpdate(UserDTO userDTO) {
        if (userDTO.getName() == null) {
            throw new IllegalArgumentException("Name is required!");
        }
        User existingUser = userDao.findByName(userDTO.getName());
        User user = getUser(userDTO);
        if (existingUser != null) {
            user.setId(existingUser.getId());
        }
        userDao.saveOrUpdate(user);
        return user;
    }

    private User getUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAmount(userDTO.getAmount());
        return user;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
