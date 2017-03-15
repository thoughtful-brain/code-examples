package com.tutorial.spring_transaction_management;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.spring_transaction_management.POJO.Employee;

@Repository
public class EmployeeReadImpl implements ReadRepository {

	@Autowired
	public SessionFactory sessionFactory;

	public List<Employee> read() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employeeList = session.createQuery("SELECT E FROM Employee E").getResultList();
		return employeeList;
	}

	public Employee readById(Integer employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = session.get(Employee.class, employeeId);
		return employee;
	}

}
