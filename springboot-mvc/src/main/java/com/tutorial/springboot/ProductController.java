package com.tutorial.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tutorial.springboot.hibernate.POJO.Product;
import com.tutorial.springboot.hibernate.service.CRUDRepository;

@Controller
public class ProductController {

	@Autowired
	private CRUDRepository crudRepository;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		return "product";
	}

	@RequestMapping(path = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> getAllEmployee() {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("Result", "OK");
		resultMap.put("Records", crudRepository.findAll());
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}

	@RequestMapping(path = "/save-edit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> saveEmployee(@ModelAttribute Product myProduct) {
		crudRepository.saveAndFlush(myProduct);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("Result", "OK");
		resultMap.put("Record", myProduct);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);

	}

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> deleteEmployee(Integer productId) {
		crudRepository.delete(productId);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("Result", "OK");
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);

	}
}
