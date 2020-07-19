package com.jdbc.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
