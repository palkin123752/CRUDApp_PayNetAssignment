package com.springRest.crudApp.dao;

import java.util.List;
import com.springRest.crudApp.entity.User;
import org.springframework.stereotype.Repository;


public interface UserDao {
    void save(User user);
    User findById(Long id);
    List<User> findAll();
    void update(User user);
    void delete(Long id);
}
