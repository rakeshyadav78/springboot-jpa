package com.jdbc.test.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegistration {

	@Bean
	public FilterRegistrationBean<EmployeeFilter> registrationBean() {
		FilterRegistrationBean<EmployeeFilter> bean = new FilterRegistrationBean<EmployeeFilter>();
		bean.setFilter(new EmployeeFilter());
		bean.setOrder(1);
		bean.addUrlPatterns("/employee/");
		return bean;
	}
}
