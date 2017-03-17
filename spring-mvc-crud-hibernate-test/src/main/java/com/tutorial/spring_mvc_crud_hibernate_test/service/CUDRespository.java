package com.tutorial.spring_mvc_crud_hibernate_test.service;

import com.tutorial.spring_mvc_crud_hibernate_test.POJO.BasePOJO;

public interface CUDRespository {

	void createOrUpdate(BasePOJO derivedObject);

	void delete(Object id);
}
