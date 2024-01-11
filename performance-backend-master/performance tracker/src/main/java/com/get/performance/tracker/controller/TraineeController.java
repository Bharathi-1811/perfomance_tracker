	package com.get.performance.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.get.performance.tracker.constants.PerformanceTrackerConstants;
import com.get.performance.tracker.entity.Trainee;
import com.get.performance.tracker.service.TraineeService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;
import com.get.performance.tracker.wrapper.TraineeLogin;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/trainee")
@RestController
public class TraineeController{

	@Autowired
	public TraineeService traineeService;
		
	@PostMapping(path="/add")
	public ResponseEntity<?> addTrainee(@RequestBody Trainee trainee) {
		
		try
		{
			return traineeService.addTrainee(trainee);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		} 
		
		return PerformanceTrackerUtils.getResponseEntity(PerformanceTrackerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);  
		 
	}
	
	@GetMapping(path="/get")
	public ResponseEntity<?> getAllTrainee() {
		
		return traineeService.getAllTrainee();
	}
	
	@GetMapping(path="/get/{id}")
	public ResponseEntity<?> getTraineeById(@PathVariable Long id) {
		
		return traineeService.getTraineeById(id);
	}
	
	
	
	@PutMapping(path="/update/{id}")
	public ResponseEntity<String> updateTrainee(@PathVariable Long id,@RequestBody Trainee trainee) {
				
		return traineeService.updateTrainee(id,trainee);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<String> deleteTrainee(@PathVariable Long id) {
		
		return traineeService.deleteTrainee(id);
	}
	
//	@PutMapping(path="/updatesignup/{id}")
//	public ResponseEntity<String> updateSignupTrainee(@PathVariable Long id,@RequestBody Trainee trainee) {
//		
//		return traineeService.updateSignupTrainee(id,trainee);
//	}
//	
	
//	@GetMapping(path="/get")
//	public ResponseEntity<?> getAllTrainee() {
//		
//		return traineeService.getAllTrainee();
//	}
	
	@GetMapping(path="/searchtrainee")
	public ResponseEntity<?> getAllSearchTrainee()
	{
		return traineeService.getAllSearchTrainee();
	}
	@GetMapping(path="/getsingletraineedetails/{zid}")
	public ResponseEntity<?> getsingletraineedetails(@PathVariable String zid)
	{
		return traineeService.getsingletraineedetails(zid);
	}
	
	//check login
	
	@PostMapping(path="/checklogin")
	public ResponseEntity<?> checkLoginDetails(@RequestBody TraineeLogin traineeLogin)
	{
		return traineeService.checkLoginDetails(traineeLogin);
	}
	
	@GetMapping(path="/getallresult/{zid}")
	public ResponseEntity<?> getAllTraineeDetails(@PathVariable String zid)
	{
		return traineeService.getAllTraineeDetails(zid);
	}
	
		
}
