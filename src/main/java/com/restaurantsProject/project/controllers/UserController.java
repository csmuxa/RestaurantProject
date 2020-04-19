package com.restaurantsProject.project.controllers;


import com.restaurantsProject.project.entities.User;
import com.restaurantsProject.project.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();

        return allUsers;
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") long id) {
        User user = userService.getUser(id);

        return user;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        User creatingUser = userService.createUser(user);

        return creatingUser;
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") long id, @RequestBody User user) {
        User updatingUser = userService.updateUser(id, user);

        return updatingUser;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(long id) {
        userService.deleteUser(id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }


}
