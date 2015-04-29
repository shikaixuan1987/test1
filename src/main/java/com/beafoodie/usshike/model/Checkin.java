package com.beafoodie.usshike.model;

import java.sql.Timestamp;

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
@Table(name = "checkin")
public class Checkin {

	private long checkinId;
	private User user;
	private Address address;
	private Timestamp checkinTime;
	private Restaurant restaurant;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getCheckinId() {
		return checkinId;
	}

	public void setCheckinId(long checkinId) {
		this.checkinId = checkinId;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId",nullable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="addressId",nullable=false)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name="checkinTime", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(Timestamp checkinTime) {
		this.checkinTime = checkinTime;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="restaurantId")
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
