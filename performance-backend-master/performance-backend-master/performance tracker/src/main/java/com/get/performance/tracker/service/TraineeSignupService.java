package com.get.performance.tracker.service;

import org.springframework.http.ResponseEntity;

import com.get.performance.tracker.entity.Trainee;


public interface TraineeSignupService {

	ResponseEntity<?> updateSignupTrainee(String id, Trainee trainee);

	ResponseEntity<?> updateStatusByToken(String token);

}
