package com.beafoodie.usshike.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	private long restaurantId;
	private String englishName;
	private String chineseName;
	private Address address;
	private int userLike;
	private int userDislike;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Column(name = "englishName", length=50)
	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	@Column(name = "chineseName", length=50)
	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="addressId",nullable = false)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "userLike")
	public int getUserLike() {
		return userLike;
	}

	public void setUserLike(int userLike) {
		this.userLike = userLike;
	}

	@Column(name = "userDislike")
	public int getUserDislike() {
		return userDislike;
	}

	public void setUserDislike(int userDislike) {
		this.userDislike = userDislike;
	}

}
