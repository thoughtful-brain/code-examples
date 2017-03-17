package com.tutorial.spring_mvc_crud_hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.spring_mvc_crud_hibernate.POJO.BasePOJO;
import com.tutorial.spring_mvc_crud_hibernate.POJO.Department;

@Repository
public class DeptCUDImpl implements CUDRespository {

	private static final Logger logger = LoggerFactory.getLogger(DeptCUDImpl.class);

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	private Department dept;

	@Override
	public void createOrUpdate(BasePOJO dept) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(dept);
		logger.info("Dept {} is succefully created/updated ", ((Department) dept).getDeptName());
	}

	@Override
	public void delete(Object deptId) {
		Session session = sessionFactory.getCurrentSession();
		dept.setDeptId((String) deptId);
		session.delete(deptId);
		logger.info("Dept {} is succefully deleted ", ((Department) dept).getDeptId());

	}

}
