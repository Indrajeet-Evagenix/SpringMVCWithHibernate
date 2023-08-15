package com.springhibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "EmployeeAddres", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private int id;

	@Column(name = "NAME", length = 20, nullable = true)
	private String name;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", insertTime=" + insertTime + "]";
	}

	@Column(name = "ROLE", length = 20, nullable = true)
	private String role;

	@Temporal(TemporalType.DATE) // Used for insert only date
	@Column(name = "insert_date", nullable = true)
	private Date insertTime;

	@Embedded
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

//	public Employee(String name, String role, Date insertTime) {
//		super();
//		
//		this.name = name;
//		this.role = role;
//		this.insertTime = insertTime;
//	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
}
