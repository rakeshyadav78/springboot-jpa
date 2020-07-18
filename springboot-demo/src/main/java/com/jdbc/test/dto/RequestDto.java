package com.jdbc.test.dto;

import com.jdbc.test.entity.Employee;

public class RequestDto {
	private Employee employee;
	private Student student;

	public RequestDto() {
	}

	public RequestDto(Employee employee, Student student) {
		super();
		this.employee = employee;
		this.student = student;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
