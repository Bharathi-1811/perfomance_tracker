package com.get.performance.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.get.performance.tracker.entity.Trainee;
import com.get.performance.tracker.service.EmailSendService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/trainee")
public class EmailSendController {


	@Autowired
	private EmailSendService emailSendService;	
	
		private String link = "http://localhost:4200/signup";
		private String uniqueLink;
		
		@PostMapping("/sendemail")
		public ResponseEntity<?> triggerMail(@RequestBody List<Trainee> trainee) {
			
			
			for(int i=0;i<trainee.size();i++)
			{
				uniqueLink = link+"/"+trainee.get(i).getZid();
				
				emailSendService.sendSimpleEmail(trainee.get(i).getEmail(),uniqueLink, "Performance Tracker Signup Link");
			
			}
			
			return PerformanceTrackerUtils.getResponseEntity("Email sended Successfully", HttpStatus.OK);
		}
		
		
		
}
