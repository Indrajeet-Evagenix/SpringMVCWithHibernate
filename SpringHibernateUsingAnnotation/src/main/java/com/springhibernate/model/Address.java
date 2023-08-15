package com.springhibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "STREET", length = 50, nullable = true)
	private String street;

	@Column(name = "PROVINCE", length = 30, nullable = true)
	private String province;

	@Column(name = "COUNTRY", length = 20, nullable = true)
	private String country;

	@Column(name = "ZIP", length = 6, nullable = true)
	private String zip;

	public Address(String street, String province, String country, String zip) {
		super();
		this.street = street;
		this.province = province;
		this.country = country;
		this.zip = zip;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
