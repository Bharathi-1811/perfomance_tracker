package com.get.performance.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.get.performance.tracker.entity.Result;
import com.get.performance.tracker.service.ResultService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/")
public class ResultController {

	@Autowired
	ResultService resultService;
	
	@GetMapping("addresult/{id}")
	public ResponseEntity<?> getResultByTestId(@PathVariable Long id)
	{
		return resultService.getResultByTestId(id);
	}
	
	@GetMapping("addresult/rid/{id}")
	public ResponseEntity<?> getResultByRid(@PathVariable Long id)
	{
		return resultService.getResultByRid(id);
	}
	
	@PutMapping("addresult/{id}")
	public ResponseEntity<?> updateResultByRid(@PathVariable Long id,@RequestBody Result result)
	{
		return resultService.updateResultByRid(id,result);
	}
	
	@GetMapping("viewresult/{id}")
	public ResponseEntity<?> viewResultByTestId(@PathVariable Long id)
	{
		return resultService.viewResultByTestId(id);
	}
	
	@GetMapping("traineepiechart/{id}")
		public ResponseEntity<?> viewGraphByTestId(@PathVariable Long id){
			return resultService.ViewGraphByTestid(id);
	}
	
}
