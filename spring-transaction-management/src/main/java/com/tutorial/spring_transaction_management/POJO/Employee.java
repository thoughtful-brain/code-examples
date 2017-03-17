package com.tutorial.spring_transaction_management.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "EMPLOYEE")
@Component
public class Employee implements BasePOJO {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	@Column(name = "AGE")
	private int age;
	@Column(name = "DESIGNATION")
	private String designation;
	
	
	public final Integer getEmployeeId() {
		return employeeId;
	}
	public final void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public final String getEmployeeName() {
		return employeeName;
	}
	public final void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public final int getAge() {
		return age;
	}
	public final void setAge(int age) {
		this.age = age;
	}
	public final String getDesignation() {
		return designation;
	}
	public final void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", age=" + age
				+ ", designation=" + designation + "]";
	}
	
	
	
	
}
