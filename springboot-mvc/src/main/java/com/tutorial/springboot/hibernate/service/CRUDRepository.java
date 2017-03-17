package com.tutorial.springboot.hibernate.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.springboot.hibernate.POJO.Product;

@Repository
public interface CRUDRepository extends JpaRepository<Product, Integer> {

	List<Product> findAll();

	Product saveAndFlush(Product myProduct);

	void delete(Integer productId);
}
