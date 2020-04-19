package com.restaurantsProject.project.services.userService;

import com.restaurantsProject.project.entities.User;
import com.restaurantsProject.project.exceptions.AlreadyExistException;
import com.restaurantsProject.project.exceptions.CouldNotDeleteDataException;
import com.restaurantsProject.project.exceptions.CouldNotUpdateDataException;
import com.restaurantsProject.project.exceptions.DataNotFoundException;
import com.restaurantsProject.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users;
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
        User gettingUser = userRepository.findByLogin(user.getLogin());
        if (gettingUser != null)
            throw new AlreadyExistException();
        User creatingUser = userRepository.save(user);
        return creatingUser;
    }

    @Override
    public User updateUser(long id, User user) {
        User updatingUser = userRepository.findById(id);
        if (updatingUser == null)
            throw new CouldNotUpdateDataException();
        updatingUser.setName(user.getName());
        updatingUser.setSurname(user.getSurname());
        User returningUser = userRepository.save(updatingUser);
        return returningUser;
    }

    @Override
    public void deleteUser(long id) {
        User deletingUser = userRepository.findById(id);
        if (deletingUser == null)
            throw new CouldNotDeleteDataException();
        userRepository.delete(deletingUser);
    }
}
