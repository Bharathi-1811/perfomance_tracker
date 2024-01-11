package com.get.performance.tracker.service;


import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

public interface ResultExportService {

	public void generateExcel(HttpServletResponse response,Long id)throws IOException;
}
