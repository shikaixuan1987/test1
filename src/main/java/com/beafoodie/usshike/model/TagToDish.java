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
@Table(name = "tagToDish")
public class TagToDish {
	private long tagToDishId;
	private Dish dish;
	private Tag tag;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getTagToDishId() {
		return tagToDishId;
	}

	public void setTagToDishId(long tagToDishId) {
		this.tagToDishId = tagToDishId;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dishId",nullable=false)
	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
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
