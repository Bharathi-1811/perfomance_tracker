package com.get.performance.tracker.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.get.performance.tracker.entity.Result;
import com.get.performance.tracker.repository.ResultRepository;
import com.get.performance.tracker.service.ResultExportService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ResultExportServiceImpl implements ResultExportService {
	@Autowired
	private ResultRepository resultRepo;
	
	public void generateExcel(HttpServletResponse response,Long id) throws IOException {
		
		List<Result> results = resultRepo.getZidAndScore(id);	
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("result");
		HSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("zid");
		row.createCell(1).setCellValue("score");
		
		int dataRowIndex = 1;
		for(Result result: results) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(result.getZid());
			dataRow.createCell(1).setCellValue(result.getScore());
			dataRowIndex++;
		}
		
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();
		}

}

