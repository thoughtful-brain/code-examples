package com.tutorial.spring_mvc_crud_hibernate.service;

import com.tutorial.spring_mvc_crud_hibernate.POJO.BasePOJO;

public interface CUDRespository {

	void createOrUpdate(BasePOJO derivedObject);

	void delete(Object id);
}
