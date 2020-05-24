package com.restaurantsProject.project.dao.userDAO;

import com.restaurantsProject.project.entities.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
