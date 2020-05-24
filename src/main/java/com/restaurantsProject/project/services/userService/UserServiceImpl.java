package com.restaurantsProject.project.services.userService;

import com.restaurantsProject.project.dao.userDAO.UserDAO;
import com.restaurantsProject.project.entities.User;
import com.restaurantsProject.project.exceptions.AlreadyExistException;
import com.restaurantsProject.project.exceptions.CouldNotDeleteDataException;
import com.restaurantsProject.project.exceptions.CouldNotUpdateDataException;
import com.restaurantsProject.project.exceptions.DataNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserDAO userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public List<User> getAllUsers() {
         /* List<User> users = userRepository.findAll();

        return users;

          */
         return null;
    }

    @Override
    public User getUser(long id) {
        User user = userRepository.findById(id);

        if (user == null)
            throw new DataNotFoundException();

        return user;
    }

    @Override
    public User createUser(User user) {
        /*User gettingUser = userRepository.findByUsername(user.
                getUsername());
        if (gettingUser != null)
            throw new AlreadyExistException();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User creatingUser = userRepository.save(user);
        return creatingUser;

         */
        return null;
    }

    @Override
    public User updateUser(long id, User user) {
        /*
        User updatingUser = userRepository.findById(id);
        if (updatingUser == null)
            throw new CouldNotUpdateDataException();
        updatingUser.setFirstName(user.getFirstName());
        updatingUser.setLastName(user.getLastName());
        User returningUser = userRepository.save(updatingUser);
        return returningUser;

         */
        return null;
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        User deletingUser = userRepository.findById(id);
        if (deletingUser == null)
            throw new CouldNotDeleteDataException();
        userRepository.deleteById(id);
    }
}
