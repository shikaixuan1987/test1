package com.beafoodie.usshike.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dish")
public class Dish {

	private long dishId;
	private String dishEnglishName;
	private String dishChineseName;
	private Restaurant restaurant;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	@Column(name = "dishEnglishName", length=20)
	public String getDishEnglishName() {
		return dishEnglishName;
	}

	public void setDishEnglishName(String dishEnglishName) {
		this.dishEnglishName = dishEnglishName;
	}

	@Column(name = "dishChineseName", length=20)
	public String getDishChineseName() {
		return dishChineseName;
	}

	public void setDishChineseName(String dishChineseName) {
		this.dishChineseName = dishChineseName;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="restaurantId",nullable=false)
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
