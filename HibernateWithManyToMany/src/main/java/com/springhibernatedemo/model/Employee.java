package com.springhibernatedemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	@Column(name = "FIRSTNAME", length = 20)
	private String firstname;

	@Column(name = "LASTNAME", length = 20)
	private String lastname;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "EMPLOYEE_MEETING", joinColumns = { @JoinColumn(name = "EMPLOYEE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "MEETING_ID") })
	private Set<Meeting> meetings = new HashSet<Meeting>();

	public Employee() {
	}

	public Employee(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}

}
