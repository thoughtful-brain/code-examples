package com.tutorial.spring_mvc_validation_crud_hibernate.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tutorial.spring_mvc_validation_crud_hibernate.POJO.Employee;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;

		ValidationUtils.rejectIfEmpty(errors, "employeeName", "NotNull.employee.employeeName");
		if (employee.getAge() < 25)
			errors.rejectValue("age", "Min.employee.age");

		if (employee.getAge() > 50)
			errors.rejectValue("age", "Max.employee.age");
	}

}
