package com.springhibernatedemo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@DiscriminatorValue("CEmp")
public class TemporaryEmployee extends Employee {
	@Column(name = "WorkingDays", nullable = true)
	private short workingDays;
	@Column(name = "ContractorName", nullable = true, length = 20)
	private String contractorName;

	public short getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(short workingDays) {
		this.workingDays = workingDays;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	@Override
	public String toString() {
		return "TemporaryEmployee [workingDays=" + workingDays + ", contractorName=" + contractorName + "]";
	}
}
