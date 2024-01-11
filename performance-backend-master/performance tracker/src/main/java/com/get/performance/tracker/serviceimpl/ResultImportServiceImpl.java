package com.get.performance.tracker.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.get.performance.tracker.entity.Result;
import com.get.performance.tracker.repository.ResultRepository;
import com.get.performance.tracker.service.ResultImportService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResultImportServiceImpl implements ResultImportService{
	
	@Autowired
	private ResultRepository resultimportRepository;

	public void saveResultToDatabase(MultipartFile file, Long id) {
		if (ExcelUploadServiceImpl.isValidExcelFile(file)) {
			try {
				System.out.println("valid");
				List<Result> resultimport = ExcelUploadServiceImpl.getResultDataFromExcel(file.getInputStream());

				for (int i = 0; i < resultimport.size(); i++) {

					this.resultimportRepository.updateScore(resultimport.get(i).getScore(), id,
							resultimport.get(i).getZid());
				}
				System.out.println(resultimport);
			} catch (IOException e) {
				throw new IllegalArgumentException("The file is not a valid excel file");
			}
		}
	}

	public List<Result> getResultImport() {
		return resultimportRepository.findAll();
	}
}
