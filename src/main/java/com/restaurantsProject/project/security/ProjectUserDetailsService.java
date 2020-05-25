package com.restaurantsProject.project.security;


import com.restaurantsProject.project.dao.userDAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProjectUserDetailsService implements UserDetailsService {


    @Autowired
    UserDAO userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.restaurantsProject.project.entities.User user =  userRepository.findByUsername(username);

        if(user==null)
            throw new UsernameNotFoundException(username);

        return new User(user.getUsername(),user.getPassword(),user.getRoles().stream().map(authority -> new SimpleGrantedAuthority(authority.getRoleName())).collect(Collectors.toSet()));
    }
}
