package com.restaurantsProject.project.controllers;


import com.restaurantsProject.project.entities.Food;
import com.restaurantsProject.project.entities.Restaurant;
import com.restaurantsProject.project.services.foodService.FoodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.text.MatchersPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.regex.Matcher;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FoodControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FoodService foodService;

    @InjectMocks
    private FoodController foodController;


    @BeforeEach
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(foodController).build();

    }

    @Test
    public void checkGetFood() throws Exception {
        Food food = new Food();
        food.setId(1);
        food.setName("testFood");
        food.setType("fastFood");

        Mockito.when(foodService.getFood(anyLong())).thenReturn(food);
        this.mockMvc.perform(get("/food/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("testFood"))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.type").value("fastFood"));

    }

    @Test
    public void checkPostFood() throws Exception{
        Restaurant restaurant=new Restaurant();
        restaurant.setId(1);
        Food food = new Food();
        food.setId(1);
        food.setName("testFood");
        food.setType("fastFood");
        food.setRestaurant(restaurant);
        Mockito.when(foodService.createFood(any())).thenReturn(food);
        this.mockMvc.perform(post("/food").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content("{}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("testFood"))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.type").value("fastFood"));

    }
}