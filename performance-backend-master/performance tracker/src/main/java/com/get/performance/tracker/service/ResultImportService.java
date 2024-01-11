package com.get.performance.tracker.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.get.performance.tracker.entity.Result;

public interface ResultImportService {

	public void saveResultToDatabase(MultipartFile file,Long id);
	
	public List<Result> getResultImport();
}
