package com.get.performance.tracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.get.performance.tracker.entity.Trainee;
import com.get.performance.tracker.service.TraineeSignupService;

import jakarta.servlet.http.HttpServlet;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/traineesignup")
@RestController  
public class TraineeSignupController {

	@Autowired
	public TraineeSignupService traineeSignupService;
	
	@PutMapping(path="/update/{id}")
	public ResponseEntity<?> updateTrainee(@PathVariable String id,@RequestBody Trainee trainee) {
				
		return traineeSignupService.updateSignupTrainee(id,trainee);
	}
	
	@GetMapping(path="/verify/{token}")
	public ResponseEntity<?> updateStatusByToken(@PathVariable String token) 
	{
		return traineeSignupService.updateStatusByToken(token);
	}
	
	
}
