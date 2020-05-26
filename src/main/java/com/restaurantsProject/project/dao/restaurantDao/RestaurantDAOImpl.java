package com.restaurantsProject.project.dao.restaurantDao;

import com.restaurantsProject.project.entities.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Restaurant save(Restaurant restaurant) {

        Session session = sessionFactory.getCurrentSession();
        session.save(restaurant);
        session.close();
        System.out.println("Inserted Successfully");
        return restaurant;
    }

    @Override
    public Restaurant update(long id, Restaurant restaurant) {
        Session session = sessionFactory.getCurrentSession();
        Restaurant persistingRestaurant = session.get(Restaurant.class,id);
        BeanUtils.copyProperties(restaurant,persistingRestaurant);
        session.update(persistingRestaurant);
        session.close();
        return persistingRestaurant;
    }

    @Override
    public List<Restaurant> findAll() {

        Session session = sessionFactory.getCurrentSession();
        List<Restaurant> restaurants = session.createQuery("From Restaurant", Restaurant.class).list();
        session.close();
        return restaurants;
    }

    @Override
    public Restaurant findRestaurantByName(String name) {
        Session session= sessionFactory.getCurrentSession();
        Restaurant restaurant=null;
        try{
        restaurant = (Restaurant)session.createQuery("from Restaurant r where r.name = :name").setParameter("name",name).getSingleResult();}
        catch (NoResultException e){
            return restaurant;
        }

        return restaurant;
    }

    @Override
    public Restaurant findRestaurantById(long id) {

        Session session = sessionFactory.getCurrentSession();
        Restaurant restaurant = session.get(Restaurant.class, id);
        session.close();
        return restaurant;
    }

    @Override
    public List<Restaurant> findAllByKitchenType(String kitchenType) {
        Session session= sessionFactory.getCurrentSession();
        List<Restaurant> restaurants = session.createQuery("from Restaurant r where r.kitchenType = :kitchenType").setParameter("kitchenType",kitchenType).list();
        session.close();
        return restaurants;
    }

    @Override
    public List<Restaurant> findAllByPriceLevel(int level) {
        Session session= sessionFactory.getCurrentSession();
        List<Restaurant> restaurants = session.createQuery("from Restaurant r where r.priceLevel = :level").setParameter("level",level).list();
        session.close();
        return restaurants;
    }

    @Override
    public void deleteRestaurantById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Restaurant restaurant = session.get(Restaurant.class, id);
        session.delete(restaurant);
        session.close();
        System.out.println("Deleted successfully");

    }
}
