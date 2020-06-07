package com.restaurantsProject.project.services.foodService;

import com.restaurantsProject.project.entities.Food;
import com.restaurantsProject.project.entities.Restaurant;
import com.restaurantsProject.project.exceptions.CouldNotDeleteDataException;
import com.restaurantsProject.project.exceptions.CouldNotUpdateDataException;
import com.restaurantsProject.project.exceptions.DataNotFoundException;
import com.restaurantsProject.project.repositories.FoodRepository;
import com.restaurantsProject.project.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    RestaurantRepository restaurantRepository;


    @Override
    public Food createFood(Food food) {
        Food createdFood = foodRepository.save(food);
        return createdFood;
    }

    @Override
    public List<Food> getFoodsByRestaurant(Restaurant restaurant) {
        Restaurant gettingRestaurant = restaurantRepository.findRestaurantById(restaurant.getId());
        if (gettingRestaurant == null)
            throw new DataNotFoundException();
        List<Food> foodsByRestaurant = foodRepository.findAllByRestaurant(restaurant);
        return foodsByRestaurant;
    }

    @Override
    public Food updateFood(long id, Food food) {
        Food updatingFood = foodRepository.findFoodById(id);
        if (updatingFood == null)
            throw new CouldNotUpdateDataException();

        updatingFood.setIngredients(food.getIngredients());
        updatingFood.setName(food.getName());
        updatingFood.setPrice(food.getPrice());
        updatingFood.setType(food.getType());
        Food returningFood = foodRepository.save(updatingFood);

        return returningFood;
    }

    @Override
    @Transactional
    public void deleteFood(long id) {
        Food deletingFood = foodRepository.findFoodById(id);
        if (deletingFood == null)
            throw new CouldNotDeleteDataException();
        foodRepository.deleteFoodById(id);
    }

    @Override
    public Food getFood(long id) {

        Food food = foodRepository.findFoodById(id);
        if (food == null)
            throw new DataNotFoundException();
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
        List<Food> allFoodsByPrice = foodRepository.findAllByPriceBetween(lower, higher);

        return allFoodsByPrice;
    }
}
