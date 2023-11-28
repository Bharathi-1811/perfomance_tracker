package com.get.performance.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.get.performance.tracker.service.AdminService;
import com.get.performance.tracker.wrapper.TraineeLogin;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping(path="/checklogin")
	public ResponseEntity<?> checkLoginDetails(@RequestBody TraineeLogin traineeLogin)
	{
		return adminService.checkLoginDetails(traineeLogin);
	}
	
	
}
