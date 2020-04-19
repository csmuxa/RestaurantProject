package com.restaurantsProject.project.services.userService;

import com.restaurantsProject.project.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(long id);

    User createUser(User user);

    User updateUser(long id,User user);

    void deleteUser(long id);


}
