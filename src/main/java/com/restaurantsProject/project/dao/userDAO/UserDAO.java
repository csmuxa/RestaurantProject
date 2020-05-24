package com.restaurantsProject.project.dao.userDAO;

import com.restaurantsProject.project.entities.User;

public interface UserDAO {

    User findByUsername(String username);

    User findById(long id);

    void deleteById(long id);

}
