package com.beafoodie.usshike.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	private long addressId;
	private String address1;
	private String address2;
	private String city;
	private State state;
	private int zipCode;
	private BigDecimal longitude;
	private BigDecimal latitude;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	@Column(name = "address1", nullable = false, length=50)
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2", nullable = true, length=50)
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city", nullable = false, length=20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", nullable = false, length=20)
	@Enumerated(EnumType.STRING)
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Column(name = "zipCode", nullable = false, length=10)
	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name="longitude", columnDefinition="Decimal(9,6)")
	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	@Column(name="latitude", columnDefinition="Decimal(9,6)")
	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

}
