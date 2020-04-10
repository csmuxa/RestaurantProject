package com.restaurantsProject.project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    @Size(min = 3, max = 20, message = "The length of name must be from 3 to 20 symbols")
    private String name;

    @Column
    private String address;

    @Column
    private int priceLevel;

    @Column
    private String kitchenType;

    @Column
    private String phone;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Food> menu;


}
