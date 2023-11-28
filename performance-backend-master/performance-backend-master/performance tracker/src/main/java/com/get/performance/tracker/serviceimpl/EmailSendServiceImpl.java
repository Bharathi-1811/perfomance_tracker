package com.get.performance.tracker.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.get.performance.tracker.service.EmailSendService;

@Service
public class EmailSendServiceImpl implements EmailSendService {

	@Autowired
	private JavaMailSender mailSender;
	public void sendSimpleEmail(String toEmail, String body, String subject) {
	
		SimpleMailMessage message = new SimpleMailMessage();
		
		
		message.setFrom("bharathi181111@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("Mail sended ...");
	}
}
