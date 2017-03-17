package com.tutorial.spring_mvc_crud_hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.spring_mvc_crud_hibernate.POJO.BasePOJO;
import com.tutorial.spring_mvc_crud_hibernate.POJO.Employee;

@Repository
public class EmployeeCUDImpl implements CUDRespository {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeCUDImpl.class);

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	private Employee employee;

	@Override
	public void createOrUpdate(BasePOJO employee) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
		logger.info("Employee {} is succefully created/updated ", ((Employee) employee).getEmployeeId());
	}

	@Override
	public void delete(Object employeeId) {
		Session session = sessionFactory.getCurrentSession();
		employee.setEmployeeId((Integer) employeeId);
		session.delete(employee);
		logger.info("Employee {} is succefully deleted ", ((Employee) employee).getEmployeeId());

	}

}
