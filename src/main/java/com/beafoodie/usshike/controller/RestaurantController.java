package com.beafoodie.usshike.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beafoodie.usshike.model.Restaurant;
import com.beafoodie.usshike.service.RestaurantService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = { "/", "/listRestaurants" })
	public String listBooks(Map<String, Object> map) {

		map.put("restaurant", new Restaurant());

		map.put("restaurantList", restaurantService.listRestaurants());

		return "/restaurant/listRestaurants";
	}

	@RequestMapping("/get/{restaurantId}")
	public String getRestaurant(@PathVariable Long restaurantId,
			Map<String, Object> map) {

		Restaurant restaurant = restaurantService.getRestaurant(restaurantId);

		map.put("restaurant", restaurant);

		return "/restaurant/restaurantForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST )
	public String saveRestaurant(
			@ModelAttribute("restaurant") Restaurant restaurant,
			BindingResult result) {

		restaurantService.saveRestaurant(restaurant);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listRestaurants";
	}

	@RequestMapping("/delete/{restaurantId}")
	public String deleteRestaurant(@PathVariable("restaurantId") Long id) {

		restaurantService.deleteRestaurant(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listBooks";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/restaurant/listRestaurants";
	}
}
