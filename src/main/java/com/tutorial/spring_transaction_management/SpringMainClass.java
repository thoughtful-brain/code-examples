package com.tutorial.spring_transaction_management;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tutorial.spring_transaction_management.POJO.Department;
import com.tutorial.spring_transaction_management.POJO.Employee;

public class SpringMainClass {

	private static Logger logger = LoggerFactory.getLogger(SpringMainClass.class);

	public void getEmployee(EmployeeService employeeService) {
		Employee employee = employeeService.getEmployeeById(1);
		logger.debug("Employee:{} ", employee);
	}

	public void getAllEmployee(EmployeeService employeeService) {
		List<Employee> employee = employeeService.getAllEmployees();
		employee.forEach(i -> logger.debug("{} - {}", i.getEmployeeId(), i.getEmployeeName()));
	}

	public void saveEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		employee.setEmployeeName("Kavita");
		employee.setAge(22);
		employee.setDesignation("SE");
		employeeService.saveEmployee(employee);

		logger.info("Record is saved...!");

	}

	public void updateEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		employee.setEmployeeName("Kavita");
		employee.setAge(24);
		employee.setDesignation("SE");
		employeeService.updateEmployee(employee);

		logger.info("Record is updated...!");

	}

	public void deleteEmployee(EmployeeService employeeService) {
		employeeService.deleteEmployee(2);
		logger.info("Record is deleted...!");

	}

	public void failEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		// employee.setEmployeeName("Kavita");
		employee.setAge(22);
		employee.setDesignation("SE");
		employeeService.saveEmployee(employee);

		logger.info("Record is saved...!");

	}

	public void saveEmployeeDept(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		employee.setEmployeeName("Mukesh");
		employee.setAge(30);
		employee.setDesignation("Manager");

		Department dept = new Department();
		dept.setDeptId("HR");
		dept.setDeptName("Human Resource");
		employeeService.saveEmployee(employee, dept);

		logger.info("Record is saved...!");

	}

	public void failEmployeeDept(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setEmployeeId(3);
		employee.setEmployeeName("Mahesh");
		employee.setAge(30);
		employee.setDesignation("Manager");

		Department dept = new Department();
		// dept.setDeptId("HR");
		dept.setDeptName("Human Resource");
		employeeService.saveEmployee(employee, dept);

		logger.info("Record is saved...!");

	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		// new SpringMainClass().getEmployee(employeeService);
		// new SpringMainClass().getAllEmployee(employeeService);
		// new SpringMainClass().saveEmployee(employeeService);
		// new SpringMainClass().updateEmployee(employeeService);
		// new SpringMainClass().deleteEmployee(employeeService);
		// new SpringMainClass().failEmployee(employeeService);
		// new SpringMainClass().saveEmployeeDept(employeeService);
		new SpringMainClass().failEmployeeDept(employeeService);
		context.close();
	}
}
