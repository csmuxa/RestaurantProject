package com.restaurantsProject.project.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;


    private String login;

    private String password;

    private String name;

    private String surname;



}
