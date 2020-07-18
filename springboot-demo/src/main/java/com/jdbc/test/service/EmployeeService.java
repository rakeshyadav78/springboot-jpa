package com.jdbc.test.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.test.dto.RequestDto;
import com.jdbc.test.entity.Employee;
import com.jdbc.test.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private static Logger log = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(RequestDto requestDto) {
		return employeeRepository.save(requestDto.getEmployee());
	}

	public Employee getEmployee(int id) {
		Optional<Employee> employee = null;
		Employee employee2 = null;
		try {
			employee = employeeRepository.getById(id);
			if (employee.isPresent()) {
				employee2 = employee.get();
				return employee2;
			} else {
				return null;
			}
		} catch (Exception e) {
		}
		return null;
	}
}
