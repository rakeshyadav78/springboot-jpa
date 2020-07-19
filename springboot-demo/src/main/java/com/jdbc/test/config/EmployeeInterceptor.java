package com.jdbc.test.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class EmployeeInterceptor implements HandlerInterceptor {
	public static final Logger log = LoggerFactory.getLogger(EmployeeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("EmployeeInterceptor.preHandle()");
		System.out.println("Request Param from url [" + request.getParameter("empId") + "]");
//		String requestBody = IOUtils.toString(new HttpRequestWrapper((HttpRequest) request.getReader()));
//		System.out.println("Request Body [" + requestBody + "]");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("EmployeeInterceptor.postHandle()");
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("EmployeeInterceptor.afterCompletion()");
	}

}
