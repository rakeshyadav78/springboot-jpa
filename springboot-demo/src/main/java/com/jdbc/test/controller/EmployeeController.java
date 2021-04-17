package com.jdbc.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.test.entity.Employee;
import com.jdbc.test.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee/")
@CrossOrigin
public class EmployeeController {

	private static Logger log = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;

	
	@PostMapping(value = "saveEmp",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee saveEmp(@RequestBody Employee employee) {
		Employee employee2=null;
		try {
			employee2=employeeService.saveEmp(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee2;
	}
	
	@GetMapping(value = "getAllEmp", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmp(){
		return employeeService.getAllEmp();
	}
}
