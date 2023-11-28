package com.get.performance.tracker.serviceimpl;


import java.security.SecureRandom;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import com.get.performance.tracker.constants.PerformanceTrackerConstants;
import com.get.performance.tracker.entity.Trainee;
import com.get.performance.tracker.repository.TraineeRepository;
import com.get.performance.tracker.service.EmailSendService;
import com.get.performance.tracker.service.TraineeSignupService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TraineeSignupServiceImpl implements TraineeSignupService {

	@Autowired
	TraineeRepository traineeRepositorySignup;
	
	@Autowired
	EmailSendService emailSendService;
	
	@Override
	public ResponseEntity<?> updateSignupTrainee(String id, Trainee trainee) {

		log.info("updatesignuptrainee{}", trainee);

		try {
			String name = trainee.getName();
			String phoneNumber = trainee.getMobileNumber();
			String password = trainee.getPassword();
			String gender = trainee.getGender();
			
			//checking name validations
			if(name.matches("^null|$"))
			{
				return PerformanceTrackerUtils.getResponseEntity("Name shouldn't be null",HttpStatus.BAD_REQUEST);
			}
			if(name.isEmpty())
			{
				return PerformanceTrackerUtils.getResponseEntity("Name shouldn't be Empty",HttpStatus.BAD_REQUEST);
			}
			if(name.length()<3 || name.length()>20)
			{
				return PerformanceTrackerUtils.getResponseEntity("Name length between 3 and 20 characters",HttpStatus.BAD_REQUEST);
			}
			
			//checking phoneNumber validations
			if(phoneNumber.matches("^null|$"))
			{
				return PerformanceTrackerUtils.getResponseEntity("phoneNumber shouldn't be null",HttpStatus.BAD_REQUEST);
			}
			if(phoneNumber.isEmpty())
			{
				return PerformanceTrackerUtils.getResponseEntity("phoneNumber shouldn't be Empty",HttpStatus.BAD_REQUEST);
			}
			if(!(Pattern.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", phoneNumber)))
			{
				return PerformanceTrackerUtils.getResponseEntity("Enter a valid phoneNumber",HttpStatus.BAD_REQUEST);
			}
			
			//checking password validations
//			if(password.matches("^null|$"))
//			{
//				return PerformanceTrackerUtils.getResponseEntity("Password shouldn't be null",HttpStatus.BAD_REQUEST);
//			}
//			if(password.isEmpty())
//			{
//				return PerformanceTrackerUtils.getResponseEntity("Password shouldn't be Empty",HttpStatus.BAD_REQUEST);
//			}
			if(!(Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,16}$", trainee.getPassword())))
			{
				return PerformanceTrackerUtils.getResponseEntity("Password must contain at least one digit,,atleast one lowercase,atleast one uppercase of at least 8 characters and a maximum of 16 characters",HttpStatus.BAD_REQUEST);
			}
			
			//checking gender
			if(gender.matches("^null|$"))
			{
				return PerformanceTrackerUtils.getResponseEntity("Gender shouldn't be null",HttpStatus.BAD_REQUEST);
			}
			if(gender.isEmpty())
			{
				return PerformanceTrackerUtils.getResponseEntity("Gender shouldn't be Empty",HttpStatus.BAD_REQUEST);
			}
			if(!(Pattern.matches("^(?:male|Male|female|Female)$",gender)))
			{
				return PerformanceTrackerUtils.getResponseEntity("Gender shouble be male,Male,female,Female",HttpStatus.BAD_REQUEST);
			}
			
			
			traineeRepositorySignup.updateSignupForm(trainee.getName(),
					trainee.getMobileNumber(), trainee.getPassword(),trainee.getGender(),id);
			
			String unique = PerformanceTrackerUtils.GenerateRandomUUIDFunction(id);
			
			String tr = traineeRepositorySignup.getTraineeEmail(id);
			emailSendService.sendSimpleEmail(tr, unique, "Please click the link below to verify your registration");			
				
			return PerformanceTrackerUtils.getResponseEntity("successfullyupdated", HttpStatus.OK);
			
			
			
				
				
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return PerformanceTrackerUtils.getResponseEntity(PerformanceTrackerConstants.SOMETHING_WENT_WRONG,
				HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@Override
	public ResponseEntity<?> updateStatusByToken(String token) {
		
		log.info("token{}",token);
		try {
			String zid = token.substring(8,15);
			System.out.println(zid);
			Trainee trai = traineeRepositorySignup.findByZid(zid);
			//if trainee not exists
			if(Objects.isNull(trai))
			{
				return PerformanceTrackerUtils.getResponseEntity("Zid Not Exits", HttpStatus.BAD_REQUEST);
			}
			else {
				//if trainee exists update status
				traineeRepositorySignup.updateTraineeStatus("true",zid);
			
				return PerformanceTrackerUtils.getResponseEntity("Email Verified Successfully", HttpStatus.OK);
			}
		 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return PerformanceTrackerUtils.getResponseEntity(PerformanceTrackerConstants.SOMETHING_WENT_WRONG,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	 
	 

	

}
