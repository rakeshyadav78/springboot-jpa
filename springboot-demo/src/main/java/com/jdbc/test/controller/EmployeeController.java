package com.jdbc.test.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbc.test.dto.RequestDto;
import com.jdbc.test.dto.ResponseDto;
import com.jdbc.test.entity.Employee;
import com.jdbc.test.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee/")
public class EmployeeController {

	private static Logger log = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
//	@Autowired(required = true)
//	private RestTemplate restTemplate;

	@PostMapping(value = "saveEmployee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus
	public ResponseDto saveEmployee(@RequestBody RequestDto requestDto,
			@RequestHeader(name = "key", required = true) String key, HttpServletResponse httpServletResponse)
			throws JsonProcessingException {
		log.info("requestDto [" + new ObjectMapper().writeValueAsString(requestDto) + "], key [" + key + "]");
		Employee employee = null;
		ResponseDto responseDto = null;
		try {
			employee = employeeService.saveEmployee(requestDto);
			if (employee != null) {
				httpServletResponse.setHeader("Name", employee.getfName());
				responseDto = new ResponseDto();
				responseDto.setMsg("Success");
				responseDto.setMsgId("0");
				responseDto.setEmployee(employee);
				System.out.println("empResponse [" + new ObjectMapper().writeValueAsString(employee) + "]");
//				return responseDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseDto = new ResponseDto();
			responseDto.setMsg("EXP01");
			responseDto.setMsgId("1");
			return responseDto;
		}
		HttpHeaders headers = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("key", "8976264058");
		HttpEntity<RequestDto> entity = new HttpEntity<RequestDto>(requestDto, headers);
		ResponseEntity<ResponseDto> responseEntity = restTemplate
				.exchange("http://localhost:8001/employee/saveEmployee", HttpMethod.POST, entity, ResponseDto.class);
		System.out.println("Rest Template Response [" + responseEntity.getBody().toString() + "]");
		return responseDto;
	}

	@PostMapping(value = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto getEmployeeById(@RequestParam("empId") int id) {
		Employee employee = employeeService.getEmployee(id);
		ResponseDto dto = new ResponseDto();
		if (employee != null) {
			dto.setEmployee(employee);
			dto.setMsg("Success");
			dto.setMsgId("1");
			return dto;
		}
		return dto;
	}

}
