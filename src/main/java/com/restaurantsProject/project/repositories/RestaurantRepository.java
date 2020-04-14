package com.restaurantsProject.project.repositories;

import com.restaurantsProject.project.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    Restaurant findRestaurantByName(String name);

    Restaurant findRestaurantById(long id);

    List<Restaurant> findAllByKitchenType(String kitchenType);

    List<Restaurant> findAllByPriceLevel(int level);

    void deleteRestaurantById(long id);




}
