package com.partha.spammer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	JavaMailSender javaMailSender;
	
    public void sendSimpleMail(String to, String subject, String text) {
    	Double x = Math.random();
    	Double y = Math.random();
    	Double z = x * y;
    	subject = subject + String.valueOf(z);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jhondoeanything@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }
}
