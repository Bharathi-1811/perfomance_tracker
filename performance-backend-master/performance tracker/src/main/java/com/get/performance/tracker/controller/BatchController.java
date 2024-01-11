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

import com.get.performance.tracker.entity.Batch;
import com.get.performance.tracker.service.BatchService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1")
public class BatchController {

			@Autowired
			BatchService batchservice;
	
			@PostMapping("/batch")
			public ResponseEntity<?> createBatch(@RequestBody Batch batch)
			{
					return  batchservice.createBatch(batch);			
			}
			@GetMapping("/batch")
			public ResponseEntity<List<Batch>> getAllBatch(){
				
					return batchservice.getAllBatch();
			}
	
			@GetMapping("/batch/{id}")
			public ResponseEntity<?> getBatchById(@PathVariable Long id) {

					return batchservice.getBatchById(id);
			}
	
			@PutMapping("/batch/{id}")
			public ResponseEntity<?> updateBatch(@PathVariable Long id,@RequestBody Batch batch){
				
					return batchservice.updateBatch(id,batch);
			}
	
			@DeleteMapping("/batch/{id}")
			public ResponseEntity<?> DeleteBatchById(@PathVariable Long id)
			{
				return batchservice.deleteBatchById(id);
			}
			
}
