package com.restaurantsProject.project.services.restaurantService;

import com.restaurantsProject.project.entities.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(long id,Restaurant restaurant);

    void deleteRestaurant(long id);

    Restaurant getRestaurant(long id);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getAllRestaurantsByKitchenType(String type);

    List<Restaurant> getAllRestaurantsByPriceLevel(int level);


}
