package com.tutorial.spring_mvc_crud_hibernate_test.service;

import java.util.List;

import com.tutorial.spring_mvc_crud_hibernate_test.POJO.Employee;

public interface ReadRepository {

	List<Employee> read();
	
	Employee readById(Integer employeeId);
}
