package com.restaurantsProject.project.repositories;

import com.restaurantsProject.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    User findById(long id);

    void deleteById(long id);





}
