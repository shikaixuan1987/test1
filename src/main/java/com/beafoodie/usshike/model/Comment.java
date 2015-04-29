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
@Table(name = "comment")
public class Comment {

	private long commentId;
	private String content;
	private Timestamp publishOn;
	private Restaurant restaurant;
	private User publishBy;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	@Column(name = "content", nullable = false, length=200)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="publishOn", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp getPublishOn() {
		return publishOn;
	}

	public void setPublishOn(Timestamp publishOn) {
		this.publishOn = publishOn;
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
	@JoinColumn(name="publishBy",nullable=false)
	public User getPublishBy() {
		return publishBy;
	}

	public void setPublishBy(User publishBy) {
		this.publishBy = publishBy;
	}

}
