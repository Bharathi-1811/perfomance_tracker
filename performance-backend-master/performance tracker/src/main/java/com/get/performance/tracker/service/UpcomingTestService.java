package com.get.performance.tracker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.get.performance.tracker.entity.UpcomingTest;

public interface UpcomingTestService {

	ResponseEntity<?> createUpcoming(UpcomingTest upcomingTest);

	ResponseEntity<?> getRetestNo(Long cid);

	ResponseEntity<List<UpcomingTest>> getAllUpcoming();
//
	ResponseEntity<?> getUpcomingById(Long testId);
//
	ResponseEntity<?> upcomingUpdate(Long testId, UpcomingTest upcomingTest);
//
	ResponseEntity<?> upcomingDelete(Long testId);

	ResponseEntity<List<UpcomingTest>> getAllPast();

	ResponseEntity<List<UpcomingTest>> getOnGoing();

}
