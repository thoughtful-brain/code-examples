package com.tutorial.spring_mvc_validation_crud_hibernate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tutorial.spring_mvc_validation_crud_hibernate.POJO.Employee;
import com.tutorial.spring_mvc_validation_crud_hibernate.service.EmployeeService;

@Controller
@RequestMapping(path = "/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private MessageSourceAccessor messageSourceAcc;

	@Autowired
	private EmployeeValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

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
	public ResponseEntity<Map<String, Object>> saveEmployee(@Validated @ModelAttribute Employee employee,
			BindingResult result) {
		Map<String, Object> resultMap = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errorMessage = new ArrayList<>();

			for (FieldError error : result.getFieldErrors()) {
				errorMessage.add(messageSourceAcc.getMessage(error.getCode()) + "\n");
			}
			resultMap.put("Result", "ERROR");
			resultMap.put("Message", errorMessage);
		} else {
			employeeService.saveEmployee(employee);
			resultMap.put("Result", "OK");
			resultMap.put("Record", employee);
		}
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
