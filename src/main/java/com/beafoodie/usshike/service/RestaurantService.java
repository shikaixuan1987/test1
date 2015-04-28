package com.beafoodie.usshike.service;

import java.util.List;

import com.beafoodie.usshike.model.Restaurant;

public interface RestaurantService {

	/*
	 * CREATE and UPDATE
	 */
	public void saveRestaurant(Restaurant restaurant);

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