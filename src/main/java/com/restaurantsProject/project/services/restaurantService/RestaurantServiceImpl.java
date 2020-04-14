package com.restaurantsProject.project.services.restaurantService;

import com.restaurantsProject.project.exceptions.AlreadyExistException;
import com.restaurantsProject.project.entities.Restaurant;
import com.restaurantsProject.project.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        if (restaurantRepository.findRestaurantByName(restaurant.getName())!=null)
            throw new AlreadyExistException("Restaurant with this name already exists");

        Restaurant createdRestaurant = restaurantRepository.save(restaurant);

        return createdRestaurant;
    }

    @Override
    public Restaurant updateRestaurant(long id, Restaurant restaurant) {
        Restaurant updatingRestaurant = restaurantRepository.findRestaurantById(id);

        updatingRestaurant.setName(restaurant.getName());
        updatingRestaurant.setAddress(restaurant.getAddress());
        updatingRestaurant.setPhone(restaurant.getPhone());
        updatingRestaurant.setPriceLevel(restaurant.getPriceLevel());
        updatingRestaurant.setKitchenType(restaurant.getKitchenType());
        updatingRestaurant.setMenu(restaurant.getMenu());

        Restaurant returningRestaurant = restaurantRepository.save(updatingRestaurant);
        return returningRestaurant;
    }

    @Override
    public void deleteRestaurant(long id) {
        restaurantRepository.deleteRestaurantById(id);
    }


    @Override
    public Restaurant getRestaurant(long id) {
        Restaurant restaurant = restaurantRepository.findRestaurantById(id);

        return restaurant;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> allRestaurants = restaurantRepository.findAll();

        return allRestaurants;
    }

    @Override
    public List<Restaurant> getAllRestaurantsByKitchenType(String type) {
        List<Restaurant> allRestaurantsByKitchenType = restaurantRepository.findAllByKitchenType(type);

        return allRestaurantsByKitchenType;
    }

    @Override
    public List<Restaurant> getAllRestaurantsByPriceLevel(int level) {
        List<Restaurant> allRestaurantsByPriceLevel = restaurantRepository.findAllByPriceLevel(level);

        return allRestaurantsByPriceLevel;
    }
}
