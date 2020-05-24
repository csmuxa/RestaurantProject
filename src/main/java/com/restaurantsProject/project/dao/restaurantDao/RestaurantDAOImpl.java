package com.restaurantsProject.project.dao.restaurantDao;

import com.restaurantsProject.project.entities.Restaurant;
import com.restaurantsProject.project.hibernateConfigurations.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Restaurant save(Restaurant restaurant) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(restaurant);
        System.out.println("Inserted Successfully");
        session.getTransaction().commit();
        session.close();
        return restaurant;
    }

    @Override
    public Restaurant findRestaurantByName(String name) {
        return null;
    }

    @Override
    public Restaurant findRestaurantById(long id) {
        return null;
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

    }
}
