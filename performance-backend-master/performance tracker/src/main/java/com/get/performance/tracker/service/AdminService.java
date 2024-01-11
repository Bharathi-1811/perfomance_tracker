package com.get.performance.tracker.service;

import org.springframework.http.ResponseEntity;

import com.get.performance.tracker.wrapper.TraineeLogin;

public interface AdminService {

	ResponseEntity<?> checkLoginDetails(TraineeLogin traineeLogin);

}
