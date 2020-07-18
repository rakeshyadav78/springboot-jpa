package com.jdbc.test.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jdbc.test.entity.Employee;

@JsonInclude(Include.NON_NULL)
public class ResponseDto {
	private String msg;
	private String msgId;
	private Employee employee;
	private Student student;
	private List<Employee> employees;
	private List<Student> students;

	public ResponseDto() {
	}

	public ResponseDto(String msg, String msgId, Employee employee, Student student, List<Employee> employees,
			List<Student> students) {
		super();
		this.msg = msg;
		this.msgId = msgId;
		this.employee = employee;
		this.student = student;
		this.employees = employees;
		this.students = students;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseDto [msg=");
		builder.append(msg);
		builder.append(", msgId=");
		builder.append(msgId);
		builder.append(", employee=");
		builder.append(employee);
		builder.append(", student=");
		builder.append(student);
		builder.append(", employees=");
		builder.append(employees);
		builder.append(", students=");
		builder.append(students);
		builder.append("]");
		return builder.toString();
	}

}
