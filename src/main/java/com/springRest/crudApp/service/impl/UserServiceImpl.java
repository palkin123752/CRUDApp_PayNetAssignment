package com.springRest.crudApp.service.impl;

import com.springRest.crudApp.dao.UserDao;
import com.springRest.crudApp.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl {

    @Autowired
    private UserDao userDao;



    public void saveUser(User user) {
        userDao.save(user);
    }



    public User getUserById(Long id) {
        return userDao.findById(id);
    }



    public List<User> getAllUsers() {
        return userDao.findAll();
    }



    public void updateUser(User user) {
        userDao.update(user);
    }


    public void deleteUser(Long id) {
        userDao.delete(id);
    }
}

