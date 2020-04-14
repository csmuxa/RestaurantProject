package com.restaurantsProject.project.services.foodService;

import com.restaurantsProject.project.entities.Food;
import com.restaurantsProject.project.entities.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;



public interface FoodService {


    Food createFood(Food food);

    List<Food> getFoodsByRestaurant(Restaurant restaurant);

    Food updateFood(long id,Food food);

    void deleteFood(long id);

    Food getFood(long id);

    List<Food> getAllFoods();

    List<Food> getFoodsByType(String type);

    List<Food> getFoodsByPrice(double lower,double higher);





}
