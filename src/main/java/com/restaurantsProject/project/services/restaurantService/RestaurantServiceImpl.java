package com.restaurantsProject.project.services.restaurantService;

import com.restaurantsProject.project.dao.restaurantDao.RestaurantDAO;
import com.restaurantsProject.project.exceptions.AlreadyExistException;
import com.restaurantsProject.project.entities.Restaurant;
import com.restaurantsProject.project.exceptions.CouldNotDeleteDataException;
import com.restaurantsProject.project.exceptions.CouldNotUpdateDataException;
import com.restaurantsProject.project.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantDAO restaurantRepository;

    @Override
    @Transactional
    public Restaurant createRestaurant(Restaurant restaurant) {
        if (restaurantRepository.findRestaurantByName(restaurant.getName()) != null)
            throw new AlreadyExistException();

        Restaurant createdRestaurant = restaurantRepository.save(restaurant);

        return createdRestaurant;
    }

    @Override
    @Transactional
    public Restaurant updateRestaurant(long id, Restaurant restaurant) {
        Restaurant updatingRestaurant = restaurantRepository.findRestaurantById(id);
        if (updatingRestaurant == null)
            throw new CouldNotUpdateDataException();

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
    @Transactional
    public void deleteRestaurant(long id) {
        Restaurant deletingRestaurant= restaurantRepository.findRestaurantById(id);
        if (deletingRestaurant==null)
            throw new CouldNotDeleteDataException();

        restaurantRepository.deleteRestaurantById(id);
    }


    @Override
    @Transactional
    public Restaurant getRestaurant(long id) {
        Restaurant restaurant = restaurantRepository.findRestaurantById(id);

        if (restaurant==null)
            throw new DataNotFoundException();

        return restaurant;
    }

    @Override
    @Transactional
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> allRestaurants = restaurantRepository.findAll();
        return allRestaurants;

    }

    @Override
    @Transactional
    public List<Restaurant> getAllRestaurantsByKitchenType(String type) {
        List<Restaurant> allRestaurantsByKitchenType = restaurantRepository.findAllByKitchenType(type);

        return allRestaurantsByKitchenType;
    }

    @Override
    @Transactional
    public List<Restaurant> getAllRestaurantsByPriceLevel(int level) {
        List<Restaurant> allRestaurantsByPriceLevel = restaurantRepository.findAllByPriceLevel(level);

        return allRestaurantsByPriceLevel;
    }
}
