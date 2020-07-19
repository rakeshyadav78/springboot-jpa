package com.jdbc.test.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

//	@Scheduled(initialDelay = 3000, fixedDelay = 2000)
	public void run1() {
		System.out.println("Hello Rakesh [" + new Date() + "]");
	}
}
