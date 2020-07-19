package com.jdbc.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class EmployeeInterceptorConfig implements WebMvcConfigurer {
	@Autowired
	EmployeeInterceptor employeeInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(employeeInterceptor);
	}
}
