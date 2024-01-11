package com.get.performance.tracker.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.get.performance.tracker.entity.UpcomingTest;
import com.get.performance.tracker.service.UpcomingTestService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/upcomingtest")
public class UpcomingTestController {

	@Autowired
	UpcomingTestService uservice;

	@PostMapping
	public ResponseEntity<?> createUpcoming(@RequestBody UpcomingTest upcomingTest) {
		return uservice.createUpcoming(upcomingTest);
	}
	@GetMapping("/getretestno/{cid}")
	public ResponseEntity<?> getRetestNo(@PathVariable Long cid)
	{
		return uservice.getRetestNo(cid);
	}

	@GetMapping
	public ResponseEntity<List<UpcomingTest>> getAllUpcoming() {

		return uservice.getAllUpcoming();
	}

	@GetMapping("/getpast")
	public ResponseEntity<List<UpcomingTest>> getAllPast() {

		return uservice.getAllPast();
	}

	@GetMapping("/getongoing")
	public ResponseEntity<List<UpcomingTest>> getOnGoing() {

		return uservice.getOnGoing();
	}
	
	
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getUpcomingById(@PathVariable Long id) {

		return uservice.getUpcomingById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> upcomingUpdate(@PathVariable Long id, @RequestBody UpcomingTest upcomingTest) {

		return uservice.upcomingUpdate(id, upcomingTest);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> upcomingDelete(@PathVariable Long id) {
		return uservice.upcomingDelete(id);
	}
	
	

}
