package com.get.performance.tracker.serviceimpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.multipart.MultipartFile;

import com.get.performance.tracker.entity.Result;


public class ExcelUploadServiceImpl {

	public static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(), "application/vnd.ms-excel");
	}

	@SuppressWarnings("resource")
	public static List<Result> getResultDataFromExcel(InputStream inputStream) {
		List<Result> resultimport = new ArrayList<>();
		try {

			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			int rowIndex = 0;
			for (Row row : sheet) {
				if (rowIndex == 0) {
					rowIndex++;
					continue;
				}
				Iterator<Cell> cellIterator = row.iterator();
				int cellIndex = 0;
				Result result = new Result();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellIndex) {
					/* case 0 -> result.setId((int) cell.getNumericCellValue()); */
					case 0 -> result.setZid(cell.getStringCellValue());
					case 1 -> result.setScore((int) cell.getNumericCellValue());
					default -> {
					}
					}
					cellIndex++;
				}
				System.out.println(result);
				resultimport.add(result);
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		return resultimport;
	}
}
