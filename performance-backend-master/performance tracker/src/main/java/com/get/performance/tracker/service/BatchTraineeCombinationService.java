package com.get.performance.tracker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.get.performance.tracker.wrapper.TraineeList;

public interface BatchTraineeCombinationService {

	ResponseEntity<?> getAllTrainees();

	ResponseEntity<?> addAllTraineesToBatch(Long id, TraineeList[] traineesList);

	ResponseEntity<?> getAllBatchTrainees();

	ResponseEntity<?> getDashboardBatch(String zid);


}
