package com.get.performance.tracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.get.performance.tracker.service.BatchTraineeCombinationService;
import com.get.performance.tracker.wrapper.TraineeList;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/batchtraineecombination")
public class BatchTraineeCombinationController {
	
	@Autowired
	BatchTraineeCombinationService batchTraineeCombinationService;
	
	@GetMapping
	public ResponseEntity<?>getAllTrainees()
	{
		return batchTraineeCombinationService.getAllTrainees();
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?>addAllTraineesToBatch(@PathVariable Long id,@RequestBody TraineeList[] traineesList)
	{
			return batchTraineeCombinationService.addAllTraineesToBatch(id,traineesList);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?>getAllBatchTrainees()
	{
		return batchTraineeCombinationService.getAllBatchTrainees();
	}
	
	@GetMapping("/getdashboardbatch/{zid}")
	public ResponseEntity<?>getDashboardBatch(@PathVariable String zid)
	{
		return batchTraineeCombinationService.getDashboardBatch(zid);
	}
}
