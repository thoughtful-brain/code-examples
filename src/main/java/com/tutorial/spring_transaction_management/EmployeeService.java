package com.tutorial.spring_transaction_management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.spring_transaction_management.POJO.Department;
import com.tutorial.spring_transaction_management.POJO.Employee;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

	@Autowired
	public ReadRepository employeeReadImpl;

	@Autowired
	@Qualifier("employeeCUDImpl")
	public CUDRespository employeeCUDRespository;

	@Autowired
	@Qualifier("deptCUDImpl")
	public CUDRespository deptCUDRespository;

	public List<Employee> getAllEmployees() {
		return employeeReadImpl.read();
	}

	public Employee getEmployeeById(Integer employeeId) {
		return employeeReadImpl.readById(employeeId);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEmployee(Employee employeeId) {
		employeeCUDRespository.createOrUpdate(employeeId);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateEmployee(Employee employee) {
		employeeCUDRespository.createOrUpdate(employee);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteEmployee(Integer employeeId) {
		employeeCUDRespository.delete(employeeId);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEmployee(Employee employeeId, Department dept) {
		employeeCUDRespository.createOrUpdate(employeeId);
		deptCUDRespository.createOrUpdate(dept);
	}

}
