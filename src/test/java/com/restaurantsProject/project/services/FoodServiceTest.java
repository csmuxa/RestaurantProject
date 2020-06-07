package com.restaurantsProject.project.services;
import com.restaurantsProject.project.entities.Food;
import com.restaurantsProject.project.entities.Restaurant;
import com.restaurantsProject.project.exceptions.CouldNotDeleteDataException;
import com.restaurantsProject.project.exceptions.DataNotFoundException;
import com.restaurantsProject.project.repositories.FoodRepository;
import com.restaurantsProject.project.repositories.RestaurantRepository;
import com.restaurantsProject.project.services.foodService.FoodService;
import com.restaurantsProject.project.services.foodService.FoodServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FoodServiceTest {

    @Mock
    private FoodRepository foodRepositoryMock;

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private FoodService foodService = new FoodServiceImpl();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void checkIfFoodNotFoundThenThrowDataNotFoundException(){
        Mockito.when(foodRepositoryMock.findFoodById(anyLong())).thenReturn(null);
        assertThrows(DataNotFoundException.class, () -> foodService.getFood(2));
    }

    @Test
    public void checkIfCreatedFoodNotNull(){
        Mockito.when(foodRepositoryMock.save(any())).thenReturn(new Food());
        Food food = foodService.createFood(new Food());
        assertThat(food).isNotNull();
    }

    @Test
    public void checkNumberOfFoodsByRestaurant(){
        List<Food> foods = new ArrayList<>();
        Restaurant restaurant=new Restaurant();
        Food food1= new Food();
        Food food2=new Food();
        foods.add(food1);
        foods.add(food2);
        Mockito.when(foodRepositoryMock.findAllByRestaurant(any())).thenReturn(foods);
        Mockito.when(restaurantRepository.findRestaurantById(anyLong())).thenReturn(restaurant);
        List<Food> testFoods = foodService.getFoodsByRestaurant(restaurant);
        Mockito.verify(foodRepositoryMock,Mockito.times(1)).findAllByRestaurant(any());
        assertThat(testFoods.size()).isEqualTo(2);

    }


    @Test
    public void checkNumberOfFoodsWhenGetAllFoods() {
        List<Food> foods = new ArrayList<>();
        Food food1 = new Food();
        Food food2 = new Food();
        Food food3 = new Food();
        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
        Mockito.when(foodRepositoryMock.findAll()).thenReturn(foods);
        List<Food> testFood = foodService.getAllFoods();
        Mockito.verify(foodRepositoryMock, Mockito.times(1)).findAll();
        assertThat(testFood.size()).isEqualTo(3);
    }

    @Test
    public void checkIfFoodNotFoundWhenDeleteThrowCouldNotDeleteDataException() {
        Mockito.when(foodRepositoryMock.findFoodById(anyLong())).thenReturn(null);
        assertThrows(CouldNotDeleteDataException.class, () -> foodService.deleteFood(2));
        Mockito.verify(foodRepositoryMock, Mockito.times(0)).deleteFoodById(anyInt());
    }

    @Test
    public void checkIfFoodFoundThenDeleteWithoutException(){
        Mockito.when(foodRepositoryMock.findFoodById(anyLong())).thenReturn(new Food());
        foodService.deleteFood(2);
        Mockito.verify(foodRepositoryMock, Mockito.times(1)).deleteFoodById(anyLong());
    }

    @Test
    public void checkNumberOfFoodsByPrice(){
        List<Food> foods = new ArrayList<>();
        Food food1= new Food();
        Food food2=new Food();
        foods.add(food1);
        foods.add(food2);
        Mockito.when(foodRepositoryMock.findAllByPriceBetween(anyDouble(),anyDouble())).thenReturn(foods);
        List<Food> testFoods = foodService.getFoodsByPrice(5,6);
        Mockito.verify(foodRepositoryMock,Mockito.times(1)).findAllByPriceBetween(anyDouble(),anyDouble());
        assertThat(testFoods.size()).isEqualTo(2);
    }

    @Test
    public void checkNumberOfFoodsByType(){
        List<Food> foods = new ArrayList<>();
        Food food1= new Food();
        Food food2=new Food();
        foods.add(food1);
        foods.add(food2);
        Mockito.when(foodRepositoryMock.findAllByType(anyString())).thenReturn(foods);
        List<Food> testFoods = foodService.getFoodsByType("Soup");
        Mockito.verify(foodRepositoryMock,Mockito.times(1)).findAllByType(anyString());
        assertThat(testFoods.size()).isEqualTo(2);
    }




}
