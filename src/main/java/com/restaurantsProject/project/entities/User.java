package com.restaurantsProject.project.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;


    @Column(unique = true)
    private String login;

    @Column
    private String encryptedPassword;

    @Column
    private String name;

    @Column
    private String surname;



}
