package com.tutorial.spring_mvc_crud_hibernate.POJO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "DEPARTMENT")
@Component
public class Department implements BasePOJO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7718799464172604786L;
	@Id
	@Column(name = "DEPT_ID")
	private String deptId;
	@Column(name = "DEPT_NAME")
	private String deptName;

	public final String getDeptId() {
		return deptId;
	}

	public final void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public final String getDeptName() {
		return deptName;
	}

	public final void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptId == null) ? 0 : deptId.hashCode());
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
		Department other = (Department) obj;
		if (deptId == null) {
			if (other.deptId != null)
				return false;
		} else if (!deptId.equals(other.deptId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}

}
