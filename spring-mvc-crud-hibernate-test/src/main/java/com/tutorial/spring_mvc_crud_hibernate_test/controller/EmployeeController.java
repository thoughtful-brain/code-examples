package com.tutorial.spring_mvc_crud_hibernate_test.controller;

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

import com.tutorial.spring_mvc_crud_hibernate_test.POJO.Employee;
import com.tutorial.spring_mvc_crud_hibernate_test.service.EmployeeService;

@Controller
@RequestMapping(path = "/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "employee";
	}

	@RequestMapping(path = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> getAllEmployee() {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("Result", "OK");
		resultMap.put("Records", employeeService.getAllEmployees());
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);

	}

	@RequestMapping(path = "/save-edit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> saveEmployee(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("Result", "OK");
		resultMap.put("Record", employee);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);

	}

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> deleteEmployee(Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("Result", "OK");
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);

	}

}
