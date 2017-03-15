package com.tutorial.spring_transaction_management;

import java.util.List;

import com.tutorial.spring_transaction_management.POJO.Employee;

public interface ReadRepository {

	List<Employee> read();
	
	Employee readById(Integer employeeId);
}
