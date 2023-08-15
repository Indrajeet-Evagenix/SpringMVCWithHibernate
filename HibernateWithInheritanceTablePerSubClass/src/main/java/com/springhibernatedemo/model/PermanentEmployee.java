package com.springhibernatedemo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PermanentEmployee")
@PrimaryKeyJoinColumn(name = "P_ID")
public class PermanentEmployee extends Employee {

	@Override
	public String toString() {
		return "PermanentEmployee [designation=" + designation + ", department=" + department + "]";
	}

	@Column(name = "Designation", length = 20, nullable = true)
	private String designation;
	@Column(name = "Department", length = 20, nullable = true)
	private String department;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
