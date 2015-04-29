package com.beafoodie.usshike.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	private long userId;
	private String wechatId;
	private String nickname;
	private String password;
	private String role;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	@Column(name="wechatId",unique = true)
	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	@Column(name="nickname",unique = true)
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
