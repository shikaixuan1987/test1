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
@Table(name = "shikeArticle")
public class ShikeArticle {

	private long articleId;
	private String tittle;
	private Timestamp publishOn;
	private User publishby;
	private String content;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	@Column(name = "tittle", length=50)
	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	@Column(name="publishOn", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp getPublishOn() {
		return publishOn;
	}

	public void setPublishOn(Timestamp publishOn) {
		this.publishOn = publishOn;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="publishby",nullable=false)
	public User getPublishby() {
		return publishby;
	}

	public void setPublishby(User publishby) {
		this.publishby = publishby;
	}

	@Column(name = "content", columnDefinition = "TEXT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
