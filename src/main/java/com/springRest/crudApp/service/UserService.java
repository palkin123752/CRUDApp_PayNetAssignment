package com.springRest.crudApp.service;

import com.springRest.crudApp.entity.User;

import java.util.List;

public interface UserService {
     void saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
}
