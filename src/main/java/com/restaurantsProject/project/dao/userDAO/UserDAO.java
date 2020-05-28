package com.restaurantsProject.project.dao.userDAO;

import com.restaurantsProject.project.entities.User;

import java.util.List;

public interface UserDAO {

    User findByUsername(String username);

    User findById(long id);

    void deleteById(long id);

    List<User> findAll();

    User save(User user);

    User update(long id,User user);

}
