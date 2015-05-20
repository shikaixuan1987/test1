package com.beafoodie.usshike.dao;

import java.util.List;

import com.beafoodie.usshike.model.Restaurant;

public interface RestaurantDao {

    /*
     * CREATE and UPDATE
     */
    public void addRestaurant(Restaurant restaurant); // create and update

    /*
     * READ
     */
    public List<Restaurant> listRestaurants();
    public Restaurant getRestaurant(Long id);

    /*
     * DELETE
     */
    public void deleteRestaurant(Long id);
}
