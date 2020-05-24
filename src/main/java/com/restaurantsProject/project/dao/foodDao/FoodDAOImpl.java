package com.restaurantsProject.project.dao.foodDao;

import com.restaurantsProject.project.entities.Food;
import com.restaurantsProject.project.hibernateConfigurations.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
public class FoodDAOImpl implements FoodDAO {


   /* @Autowired
    public FoodDAOImpl(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    } */


    @Override
    public Food save(Food food) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(food);
        System.out.println("Inserted Successfully");
        session.getTransaction().commit();
        session.close();
        return food;
    }

    @Override
    public List<Food> findAllByType(String type) {
        return null;
    }

    @Override
    public Food findFoodById(long id) {
        return null;
    }

    @Override
    public void deleteFoodById(long id) {

    }

    @Override
    public List<Food> findAllByPriceBetween(double lower, double higher) {
        return null;
    }
}
