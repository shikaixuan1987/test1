package com.beafoodie.usshike.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beafoodie.usshike.dao.RestaurantDao;
import com.beafoodie.usshike.model.Restaurant;
import com.beafoodie.usshike.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

       @Autowired
       private RestaurantDao restaurantDao;

       @Transactional
       public void addRestaurant(Restaurant restaurant) {
    	   restaurantDao.addRestaurant(restaurant);
       }

       @Transactional( readOnly = true)
       public List<Restaurant> listRestaurants() {
              return restaurantDao.listRestaurants();
       }

       @Transactional( readOnly = true)
       public Restaurant getRestaurant(Long id) {
              return restaurantDao.getRestaurant(id);
       }

       @Transactional
       public void deleteRestaurant(Long id) {
    	   restaurantDao.deleteRestaurant(id);

       }


}