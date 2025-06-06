package com.partha.spammer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.partha.spammer.utility.DynamicScheduler;

@Controller
public class SpamController {
	
	@Autowired
	DynamicScheduler dynamicScheduler;
	
	/*
	 * @PostMapping("/start") Object startTask() { dynamicScheduler.startTask();
	 * return new ResponseEntity<>("Task Started... See console...", HttpStatus.OK);
	 * }
	 * 
	 * @PostMapping("/stop") Object stopTask() { dynamicScheduler.stopTask(); return
	 * new ResponseEntity<>("Task Stopped... See console...", HttpStatus.OK); }
	 */
	
	
}
