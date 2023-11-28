package com.get.performance.tracker.service;

import org.springframework.http.ResponseEntity;

import com.get.performance.tracker.entity.Result;

public interface ResultService {

	ResponseEntity<?> getResultByTestId(Long testId);

	ResponseEntity<?> getResultByRid(Long id);

	ResponseEntity<?> updateResultByRid(Long id,Result result);

	ResponseEntity<?> viewResultByTestId(Long id);

	ResponseEntity<?> ViewGraphByTestid(Long id);

	
}
