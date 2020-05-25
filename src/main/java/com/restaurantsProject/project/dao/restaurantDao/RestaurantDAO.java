package com.restaurantsProject.project.dao.restaurantDao;

import com.restaurantsProject.project.entities.Restaurant;

import java.util.List;

public interface RestaurantDAO {

    Restaurant save(Restaurant restaurant);

    List<Restaurant> findAll();

    Restaurant findRestaurantByName(String name);

    Restaurant findRestaurantById(long id);

    List<Restaurant> findAllByKitchenType(String kitchenType);

    List<Restaurant> findAllByPriceLevel(int level);

    void deleteRestaurantById(long id);
}
