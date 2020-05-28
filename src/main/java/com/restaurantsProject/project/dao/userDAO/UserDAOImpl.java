package com.restaurantsProject.project.dao.userDAO;

import com.restaurantsProject.project.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import javax.persistence.NoResultException;
import java.util.List;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user=null;

        try {
           user = (User)session.createQuery("from users u where u.username = :name").setParameter("name",username).getSingleResult();
        } catch (NoResultException e) {
            return user;
        }
        return null;
    }

    @Override
    public User findById(long id) {
        Session session=sessionFactory.getCurrentSession();
        User user = session.get(User.class,id);
        return user;
    }

    @Override
    public void deleteById(long id) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        Session session= sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from users",User.class).list();
        return users;
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    public User update(long id,User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User persistingUser = session.get(User.class,id);
        BeanUtils.copyProperties(user,persistingUser,"id");
        return persistingUser;
    }
}
