package com.beafoodie.usshike.dao.impl;

import java.util.List;

import com.beafoodie.usshike.dao.RestaurantDao;
import com.beafoodie.usshike.model.Restaurant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDaoImpl implements RestaurantDao {

       @Autowired
       private SessionFactory sessionFactory;

       public void addRestaurant(Restaurant restaurant) {
              
              getSession().saveOrUpdate(restaurant);
              getSession().flush();
              getSession().close();
       }

       public List<Restaurant> listRestaurants() {

              return getSession().createCriteria(Restaurant.class).list();
       }

       public Restaurant getRestaurant(Long id) {
              return (Restaurant) getSession().get(Restaurant.class, id);
       }

       public void deleteRestaurant(Long id) {

    	   Restaurant restaurant = getRestaurant(id);

              if (null != restaurant) {
                     getSession().delete(restaurant);
                     getSession().flush();
                     getSession().close();
              }
       }

       private Session getSession() {
              Session sess = getSessionFactory().getCurrentSession();
              if (sess == null) {
                     sess = getSessionFactory().openSession();
              }
              return sess;
       }

       private SessionFactory getSessionFactory() {
              return sessionFactory;
       }
}
