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

import com.get.performance.tracker.entity.BatchTopicCombination;
import com.get.performance.tracker.service.BatchTopicCombinationService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/batchtopiccombination")
public class BatchTopicCombinationController {

	@Autowired
	BatchTopicCombinationService combinationService;

	//create combo
	@PostMapping
	public ResponseEntity<?> createCombination(@RequestBody BatchTopicCombination combination) {
		return combinationService.createCombination(combination);
	}

	// get all combo
	@GetMapping
	public ResponseEntity<?> getAllBatchTopicCombination() {

		return combinationService.getAllBatchTopicCombination();
	}

	// get combo by id
	@GetMapping("/{id}")
	public ResponseEntity<?> getBatchTopicCombinationById(@PathVariable Long id) {

		return combinationService.getBatchTopicCombinationById(id);
	}

	// update combo by id
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBatchTopicCombination(@PathVariable Long id, @RequestBody BatchTopicCombination combination) {

		return combinationService.updateBatchTopicCombination(id, combination);
	}

	// delete combo by id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteBatchTopicCombinationById(@PathVariable Long combinationid) {
		return combinationService.DeleteBatchTopicCombinationById(combinationid);
	}
	
	@GetMapping("/dashboard/{id}")
	public ResponseEntity<?> getDashboardAllTopic(@PathVariable Long id) {

		return combinationService.getDashboardAllTopic(id);
	}

	//based on topic id and zid getting score
	@GetMapping("/dashboard/{id}/{zid}")
	public ResponseEntity<?> getScoreByTopicId(@PathVariable Long id,@PathVariable String zid) {

		return combinationService.getScoreByTopicId(id,zid);
	}

	
	 

}
