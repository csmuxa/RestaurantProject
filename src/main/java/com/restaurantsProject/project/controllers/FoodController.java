package com.restaurantsProject.project.controllers;

import com.restaurantsProject.project.entities.Food;
import com.restaurantsProject.project.services.foodService.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Food createFood(@RequestBody Food food) {

        Food creatingFood = foodService.createFood(food);

        return creatingFood;
    }


    @GetMapping("{id}")
    public Food getFood(@PathVariable("id") long id) {
        Food food = foodService.getFood(id);

        return food;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable("id") long id) {
        foodService.deleteFood(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }

    @GetMapping("/{lower}/{higher}")
    public List<Food> getFoodsByPrice(@PathVariable("lower") double lower, @PathVariable("higher") double higher) {
        List<Food> allFoodsByPrice = foodService.getFoodsByPrice(lower, higher);
        return allFoodsByPrice;
    }

}
