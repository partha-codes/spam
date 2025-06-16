package com.partha.spammer.utility;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import com.partha.spammer.Service.MailService;

@Component
public class DynamicScheduler {
	@Autowired
	private ThreadPoolTaskScheduler taskScheduler;
	@Autowired
	private MailService mailService;
	
	private ScheduledFuture<?> scheduledTask;
	private static String to; 
	
	public void startTask(String mail) {
		if(scheduledTask == null || scheduledTask.isCancelled()) {
			scheduledTask = taskScheduler.scheduleAtFixedRate(this:: runTask, 10000);
			DynamicScheduler.to = mail;
			System.out.println("Task Started...");
		}
	}
	public void runTask() {
		String now = LocalDateTime.now().toString();
		System.out.println("The mail is being fired to : " + DynamicScheduler.to);
		mailService.sendSimpleMail(DynamicScheduler.to, "THIS IS SPAMMER VERSION 1", "This mail was sent now :" + now);
		System.out.println("================================ I am running =============================");
	}
	
	public void stopTask() {
		if(scheduledTask != null && !scheduledTask.isCancelled()) {
			scheduledTask.cancel(true);
			System.out.println("Task Stopped...");
			DynamicScheduler.to = "";
		}
	}
}
