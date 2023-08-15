package com.springhibernatedemo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorType;

@Entity
@Table(name = "Employee", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
//Here we are using One Table Per Class Hierarchy 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EmployeeType", discriminatorType = DiscriminatorType.STRING, length = 10)
@DiscriminatorValue(value = "Emp")
public class Employee {

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private int id;

	@Column(name = "NAME", length = 20, nullable = true)
	private String name;

	@Column(name = "Salary", nullable = true)
	private int sal;

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
