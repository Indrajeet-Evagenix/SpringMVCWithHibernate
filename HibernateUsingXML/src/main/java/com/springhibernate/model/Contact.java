package com.springhibernate.model;

public class Contact extends Employee {

	private int id;
	private String homeNumber;
	private String selfNumber;

	@Override
	public String toString() {
		return "Contact [id=" + id + ", homeNumber=" + homeNumber + ", selfNumber=" + selfNumber + "]";
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getSelfNumber() {
		return selfNumber;
	}

	public void setSelfNumber(String selfNumber) {
		this.selfNumber = selfNumber;
	}

}
