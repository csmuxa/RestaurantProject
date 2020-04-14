package com.restaurantsProject.project.services.foodService;

import com.restaurantsProject.project.entities.Food;
import com.restaurantsProject.project.entities.Restaurant;
import com.restaurantsProject.project.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;


    @Override
    public Food createFood(Food food) {
        Food createdFood = foodRepository.save(food);


        return createdFood;
    }

    @Override
    public List<Food> getFoodsByRestaurant(Restaurant restaurant) {
        List<Food> foodsByRestaurant = foodRepository.findAllByRestaurant(restaurant);

        return foodsByRestaurant;
    }

    @Override
    public Food updateFood(long id, Food food) {
        Food updatingFood = foodRepository.findFoodById(id);
        return null;
    }

    @Override
    public void deleteFood(long id) {
        foodRepository.deleteFoodById(id);
    }

    @Override
    public Food getFood(long id) {
        Food food = foodRepository.findFoodById(id);
        return food;
    }



    @Override
    public List<Food> getAllFoods() {
        List<Food> allFoods = foodRepository.findAll();

        return allFoods;
    }

    @Override
    public List<Food> getFoodsByType(String type) {
        List<Food> allFoodsByType = foodRepository.findAllByType(type);

        return allFoodsByType;
    }

    @Override
    public List<Food> getFoodsByPrice(double lower, double higher) {
        List<Food> allFoodsByPrice = foodRepository.findAllByPriceBetween(lower,higher);

        return allFoodsByPrice;
    }
}
