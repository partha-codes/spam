package com.partha.spammer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.partha.spammer.utility.DynamicScheduler;

@Controller
@SessionAttributes("email")
public class SpamUIController {
	@Autowired
	DynamicScheduler scheduler;

	@ModelAttribute("email")
	public String getEmail() {
		return ""; // Default value in case email isn't set
	}

	@GetMapping("/home")
	String getHomePage() {
		return "home";
	}

	@GetMapping("/action")
	String getActionPage() {
		return "action";
	}

	@PostMapping("/submit")
	String actionPage(@RequestParam("email") String email, Model model) {
		System.out.println("===================> " + email);
		model.addAttribute("email", email);
		return "action";
	}
	
	@PostMapping("/start")
    public String startAction(@ModelAttribute("email") String email) {
        System.out.println("START button clicked! Email: " + email);
        scheduler.startTask();
        return "action";
    }

    @PostMapping("/stop")
    public String stopAction(@ModelAttribute("email") String email) {
        System.out.println("STOP button clicked! Email: " + email);
        scheduler.stopTask();
        return "action";
    }

    @PostMapping("/exit")
    public String exitAction(@ModelAttribute("email") String email) {
        System.out.println("EXIT button clicked! Email: " + email);
        scheduler.stopTask();
        return "home";
    }
	
	

}
