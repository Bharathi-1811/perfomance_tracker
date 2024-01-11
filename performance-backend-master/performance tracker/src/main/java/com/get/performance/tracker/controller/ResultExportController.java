package com.get.performance.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.get.performance.tracker.service.ResultExportService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/resultexport")
public class ResultExportController {
	@Autowired
	private ResultExportService resultService;

	@GetMapping("/excel/{id}")
	public void generateExcelReport(HttpServletResponse response,@PathVariable Long id)  throws Exception{
		
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=perfomance.xls";
		
		response.setHeader(headerKey, headerValue);
		
		resultService.generateExcel(response,id);
	}
}
