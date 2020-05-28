package com.restaurantsProject.project.dao.foodDao;

import com.restaurantsProject.project.entities.Food;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository

public class FoodDAOImpl implements FoodDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Food> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Food> foods = session.createQuery("From Food").list();
        return foods;
    }

    @Override
    public Food save(Food food) {
        Session session = sessionFactory.getCurrentSession();
        session.save(food);
        System.out.println("Inserted Successfully");
        return food;

    }

    @Override
    public Food updateFood(long id, Food food) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Food persistingFood = session.get(Food.class, id);
        BeanUtils.copyProperties(food,persistingFood,"id");
        session.getTransaction().commit();
        session.close();
        return persistingFood;
    }

    @Override
    public List<Food> findAllByType(String type) {
        Session session = sessionFactory.getCurrentSession();
        List<Food> byFood = session.createQuery("from Food where type = :type").setParameter("type", type).list();
        return byFood;
    }

    @Override
    public Food findFoodById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Food food = session.get(Food.class, id);
        return food;

    }

    @Override
    public void deleteFoodById(long id) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Food food = session.get(Food.class, id);
        session.delete(food);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Food> findAllByPriceBetween(double lower, double higher) {
        Session session = sessionFactory.getCurrentSession();
        List<Food> foods = session.createQuery("from Food where price between :lower and :higher").setParameter("lower", lower).setParameter("higher", higher).list();
        return foods;
    }
}
