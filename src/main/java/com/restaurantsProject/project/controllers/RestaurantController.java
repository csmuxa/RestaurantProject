package com.restaurantsProject.project.controllers;


import com.restaurantsProject.project.entities.Food;
import com.restaurantsProject.project.entities.Restaurant;
import com.restaurantsProject.project.services.foodService.FoodService;
import com.restaurantsProject.project.services.restaurantService.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    FoodService foodService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {

        Restaurant creatingRestaurant = restaurantService.createRestaurant(restaurant);

        return creatingRestaurant;

    }

    @GetMapping("{id}")
    public Restaurant getRestaurant(@PathVariable("id") long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    }


    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> allRestaurants = restaurantService.getAllRestaurants();

        return allRestaurants;

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable("id") long id) {
        restaurantService.deleteRestaurant(id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }

    @GetMapping("/{kitchenType}")
    public List<Restaurant> getAllRestaurantByKitchenType(@PathVariable("kitchenType") String kitchenType) {
        List<Restaurant> allRestaurantByKitchenType = restaurantService.getAllRestaurantsByKitchenType(kitchenType);
        return allRestaurantByKitchenType;
    }


    @GetMapping("/{priceLevel}")
    public List<Restaurant> getAllRestaurantByPriceLevel(@PathVariable("priceLevel") int priceLevel) {
        List<Restaurant> allRestaurantByPriceLevel = restaurantService.getAllRestaurantsByPriceLevel(priceLevel);
        return allRestaurantByPriceLevel;
    }

    @GetMapping("{id}/foods")
    public List<Food> getFoodsByRestaurant(@PathVariable("id") long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        List<Food> foodsByRestaurant = foodService.getFoodsByRestaurant(restaurant);
        return foodsByRestaurant;
    }
}
