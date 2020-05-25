package com.restaurantsProject.project.dao.restaurantDao;

import com.restaurantsProject.project.entities.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Restaurant save(Restaurant restaurant) {

        Session session = sessionFactory.getCurrentSession();
        session.save(restaurant);
        System.out.println("Inserted Successfully");
        return restaurant;
    }

    @Override
    public List<Restaurant> findAll() {

        Session session = sessionFactory.getCurrentSession();
        List<Restaurant> restaurants = session.createQuery("From Restaurant", Restaurant.class).list();
        return restaurants;
    }

    @Override
    public Restaurant findRestaurantByName(String name) {
        return null;
    }

    @Override
    public Restaurant findRestaurantById(long id) {

        Session session = sessionFactory.getCurrentSession();
        Restaurant restaurant = session.get(Restaurant.class, id);
        return restaurant;
    }

    @Override
    public List<Restaurant> findAllByKitchenType(String kitchenType) {
        return null;
    }

    @Override
    public List<Restaurant> findAllByPriceLevel(int level) {
        return null;
    }

    @Override
    public void deleteRestaurantById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Restaurant restaurant = session.get(Restaurant.class, id);
        session.delete(restaurant);
        System.out.println("Deleted successfully");

    }
}
