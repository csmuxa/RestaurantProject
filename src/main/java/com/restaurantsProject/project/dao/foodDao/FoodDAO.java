package com.restaurantsProject.project.dao.foodDao;

import com.restaurantsProject.project.entities.Food;

import java.util.List;

public interface FoodDAO {

    List<Food> findAll();

    Food save(Food food);

    Food updateFood(long id,Food Food);

    List<Food> findAllByType(String type);

    Food findFoodById(long id);

    void deleteFoodById(long id);

    List<Food> findAllByPriceBetween(double lower,double higher);
}
