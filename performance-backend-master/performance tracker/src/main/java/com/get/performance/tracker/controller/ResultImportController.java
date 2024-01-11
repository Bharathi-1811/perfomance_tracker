package com.get.performance.tracker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.get.performance.tracker.entity.Result;
import com.get.performance.tracker.service.ResultImportService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/resultimport")
public class ResultImportController {
	
    private ResultImportService resultimportService;

    @PostMapping("/upload/{id}")
    public ResponseEntity<?> uploadResultData(@RequestParam("file")MultipartFile file, @PathVariable Long id)throws Exception{
    		System.out.println("working");
        this.resultimportService.saveResultToDatabase(file,id);
        return ResponseEntity
                .ok(Map.of("Message" , " Result data uploaded and saved to database successfully"));
    }

    @GetMapping
    public ResponseEntity<List<Result>> getResultImport(){
        return new ResponseEntity<>(resultimportService.getResultImport(), HttpStatus.FOUND);
    }
}
