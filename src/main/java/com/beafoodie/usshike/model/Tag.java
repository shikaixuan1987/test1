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
@Table(name = "tag")
public class Tag {

	private long tagId;
	private String tagEnglish;
	private String tagChinese;
	private Timestamp createdOn;
	private User createdBy;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	@Column(name = "tagEnglish", length = 200)
	public String getTagEnglish() {
		return tagEnglish;
	}

	public void setTagEnglish(String tagEnglish) {
		this.tagEnglish = tagEnglish;
	}

	@Column(name = "tagChinese", length = 200)
	public String getTagChinese() {
		return tagChinese;
	}

	public void setTagChinese(String tagChinese) {
		this.tagChinese = tagChinese;
	}

	@Column(name = "createdOn", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdBy")
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

}
