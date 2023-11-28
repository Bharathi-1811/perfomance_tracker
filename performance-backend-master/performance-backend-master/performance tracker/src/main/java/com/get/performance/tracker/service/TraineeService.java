package com.get.performance.tracker.service;

import org.springframework.http.ResponseEntity;

import com.get.performance.tracker.entity.Trainee;
import com.get.performance.tracker.wrapper.TraineeLogin;

public interface TraineeService {  

	ResponseEntity<?> addTrainee(Trainee trainee);
	ResponseEntity<String> updateTrainee(Long id,Trainee trainee);
	ResponseEntity<String> deleteTrainee(Long id);
//	ResponseEntity<String> updateSignupTrainee(Long id, Trainee trainee);
	ResponseEntity<?> getAllTrainee();
	ResponseEntity<?> getTraineeById(Long id);
	ResponseEntity<?> getAllSearchTrainee();
	ResponseEntity<?> getsingletraineedetails(String zid);
	ResponseEntity<?> checkLoginDetails(TraineeLogin traineeLogin);
	ResponseEntity<?> getAllTraineeDetails(String zid);

}
