package com.restaurantsProject.project.repositories;

import com.restaurantsProject.project.entities.Food;
import com.restaurantsProject.project.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByType(String type);

    Food findFoodById(long id);

    void deleteFoodById(long id);

    List<Food> findAllByPriceBetween(double lower,double higher);




}
