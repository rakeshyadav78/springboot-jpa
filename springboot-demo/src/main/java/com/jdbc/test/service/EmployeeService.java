package com.jdbc.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbc.test.entity.Employee;
import com.jdbc.test.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private static Logger log = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmp(Employee employee) {
		
		Employee employee2 = null;
		try {
			log.debug("employee "+new ObjectMapper().writeValueAsString(employee));
			employee2 = employeeRepository.save(employee);
			log.debug("Return Success");
			log.debug("employee2 [" + new ObjectMapper().writeValueAsString(employee2) + "]");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee2;
	}
	
	public List<Employee> getAllEmp(){
		List<Employee> employees=employeeRepository.getAllEmployee();
		return employees;
	}
}
