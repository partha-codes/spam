package com.partha.spammer.utility;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	//@Scheduled(fixedRate = 5000)
	public void writeLog() {
		System.out.println("================================= I am scheduled ===========================");
	}
}
