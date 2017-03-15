package com.tutorial.spring_transaction_management;

import com.tutorial.spring_transaction_management.POJO.BasePOJO;

public interface CUDRespository {

	void createOrUpdate(BasePOJO derivedObject);

	void delete(Object id);
}
