package com.beafoodie.usshike.model;

import java.sql.Timestamp;

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
@Table(name = "shikeScore")
public class ShikeScore {

	private long scoreId;
	private User user;
	private int monthlyScore;
	private int totalScore;
	private Timestamp lastUpdate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getScoreId() {
		return scoreId;
	}

	public void setScoreId(long scoreId) {
		this.scoreId = scoreId;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId",nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "monthlyScore")
	public int getMonthlyScore() {
		return monthlyScore;
	}

	public void setMonthlyScore(int monthlyScore) {
		this.monthlyScore = monthlyScore;
	}

	@Column(name = "totalScore")
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Column(name="lastUpdate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
