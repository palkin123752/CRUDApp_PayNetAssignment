package com.springRest.crudApp.rest;

import com.springRest.crudApp.entity.User;
import com.springRest.crudApp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }


    @GetMapping("/view-all-user")
    public List<User> viewAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> viewUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/remove/{userId}")
    public ResponseEntity<Void> removeUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            userService.deleteUser(userId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
        User user = userService.getUserById(userId);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setAge(userDetails.getAge());
            user.setAddress(userDetails.getAddress());
            user.setEmailAddress(userDetails.getEmailAddress());
            user.setStatus(userDetails.getStatus());
            userService.updateUser(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

