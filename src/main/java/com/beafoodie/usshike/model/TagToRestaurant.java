package com.beafoodie.usshike.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tagToRestaurant")
public class TagToRestaurant {

	private long tagToRestaurantId;
	private Restaurant restaurant;
	private Tag tag;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getTagToRestaurantId() {
		return tagToRestaurantId;
	}

	public void setTagToRestaurantId(long tagToRestaurantId) {
		this.tagToRestaurantId = tagToRestaurantId;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="restaurantId",nullable=false)
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tagId",nullable=false)
	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}
