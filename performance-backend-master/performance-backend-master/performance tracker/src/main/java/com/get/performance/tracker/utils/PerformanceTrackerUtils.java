package com.get.performance.tracker.utils;


import java.security.SecureRandom;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;



public class PerformanceTrackerUtils {

	private PerformanceTrackerUtils()
	{
		 
	}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage,HttpStatus httpStatus)
	{
		return new ResponseEntity<>("{\"message\":\""+responseMessage+"\"}",httpStatus);
	} 
	
	public static Long generateNewTestId(Long combinationId)
	{
		
		return (combinationId-1) * 30 + 1;
	}
	
	public static Long incrementOldTestId(Long testId,Long oldTestId)
	{
		return testId + oldTestId;
	}
	
	public static String GenerateRandomUUIDFunction(String zid)
	{
		String uuid = UUID.randomUUID().toString().replace("-", zid);
	    uuid= "http://localhost:8090/traineesignup/verify/" + uuid;
		return uuid;
		
	}
	
	
}
