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
@Table(name = "photo")
public class Photo {
	private long photoId;
	private String path;
	private String tittle;
	private Timestamp uploadOn;
	private User uploadBy;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	@Column(name = "path", length=200)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "tittle", length=100)
	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	@Column(name="uploadOn", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp getUploadOn() {
		return uploadOn;
	}

	public void setUploadOn(Timestamp uploadOn) {
		this.uploadOn = uploadOn;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="uploadBy")
	public User getUploadBy() {
		return uploadBy;
	}

	public void setUploadBy(User uploadBy) {
		this.uploadBy = uploadBy;
	}
	
	

}
