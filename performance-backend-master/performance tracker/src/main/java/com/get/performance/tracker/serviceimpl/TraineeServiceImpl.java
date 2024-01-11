package com.get.performance.tracker.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.get.performance.tracker.constants.PerformanceTrackerConstants;
import com.get.performance.tracker.entity.Trainee;
import com.get.performance.tracker.repository.TraineeRepository;
import com.get.performance.tracker.service.TraineeService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;
import com.get.performance.tracker.wrapper.TraineeLogin;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TraineeServiceImpl implements TraineeService{

	@Autowired
	TraineeRepository traineeRepository;
	
	@Override
	public ResponseEntity<?> addTrainee(Trainee trainee) {
		
		//log current  trainee object information
		log.info("Inside addTrainee {}",trainee);
		
		try {
			if(validateSignUp(trainee))
			{
				Trainee trainee1 = traineeRepository.findByZid(trainee.getZid());
				Trainee trainee2 = traineeRepository.findByEmailId(trainee.getEmail());
					
				if(Objects.isNull(trainee1))
				{	
					if(Objects.isNull(trainee2))
					{
						  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
						  Date date = new Date();  
						   
						  trainee.setBatch(formatter.format(date));
						  trainee.setStatus("false");
						return new ResponseEntity<>(traineeRepository.save(trainee),HttpStatus.OK);
					}
					else {
						return PerformanceTrackerUtils.getResponseEntity("Email already exits.", HttpStatus.BAD_REQUEST);
					}
				}
				else{
						return PerformanceTrackerUtils.getResponseEntity("Zid already exits.", HttpStatus.BAD_REQUEST);
				}
					
			}
			else{
				return PerformanceTrackerUtils.getResponseEntity("Somefield is empty fill all fields must", HttpStatus.BAD_REQUEST);
			}
				
		}catch(Exception ex){
			 
			ex.printStackTrace();
		}
		return PerformanceTrackerUtils.getResponseEntity(PerformanceTrackerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);  
	}
		
		
	public boolean validateSignUp(Trainee trainee)
	{
		System.out.println("working validate");
		if(Objects.isNull(trainee))
		{
			return false;
		}
		return true;
	}


	@Override
	public ResponseEntity<String> updateTrainee(Long id, Trainee trainee) {
	
		log.info("updatetrainee{}",trainee);
		
		try {
			if(validateSignUp(trainee))
			{
					
				Trainee traineeAct = traineeRepository.findById(id).get();
				BeanUtils.copyProperties(trainee,traineeAct);
				traineeRepository.save(traineeAct);
				return PerformanceTrackerUtils.getResponseEntity("Successfully Updated.", HttpStatus.OK);	
			}
			else{
				return PerformanceTrackerUtils.getResponseEntity("Somefield is empty fill all fields must", HttpStatus.BAD_REQUEST);
			}
				
		}catch(Exception ex){
			 
			ex.printStackTrace();
		}
		return PerformanceTrackerUtils.getResponseEntity(PerformanceTrackerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
			
	}


	@Override
	public ResponseEntity<String> deleteTrainee(Long id) {
		try {
			traineeRepository.deleteById(id);
			return PerformanceTrackerUtils.getResponseEntity("Successfully Deleted.", HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return PerformanceTrackerUtils.getResponseEntity(PerformanceTrackerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
////signup form trainee updating their details(name,password)
//	public ResponseEntity<String> updateSignupTrainee(Long id, Trainee trainee) {
//		
//			log.info("updateSignUpTrainee{}",trainee);
//			try {
//				
//				Trainee traineeAct = traineeRepository.findById(id).get();
//				traineeAct.setName(trainee.getName());
//				traineeAct.setMobileNumber(trainee.getMobileNumber());
//				traineeAct.setGender(trainee.getGender());
//				traineeAct.setPassword(trainee.getPassword());
//				traineeRepository.save(traineeAct);
//				return PerformanceTrackerUtils.getResponseEntity("Successfully Updated Signupdata.", HttpStatus.OK);
//			}
//			catch(Exception ex)
//			{
//				ex.printStackTrace();
//			}
//			return PerformanceTrackerUtils.getResponseEntity(PerformanceTrackerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//

	@Override
	public ResponseEntity<?> getAllTrainee() {
		
		try {
			return new ResponseEntity<>(traineeRepository.findAll(),HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return PerformanceTrackerUtils.getResponseEntity(PerformanceTrackerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}


	@Override
	public ResponseEntity<?> getTraineeById(Long id) {

		try {
			Optional<Trainee> traineeById = traineeRepository.findById(id);
			
			if(traineeById.isPresent())
			{
				return new ResponseEntity<>(traineeById.get(),HttpStatus.OK); 
			}
			else {
				return PerformanceTrackerUtils.getResponseEntity("trainee id not exists", HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return PerformanceTrackerUtils.getResponseEntity(PerformanceTrackerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}


	@Override
	public ResponseEntity<?> getAllSearchTrainee() {
		
		return new ResponseEntity<>(traineeRepository.getAllSearchTrainee(),HttpStatus.OK);
	}


	@Override
	public ResponseEntity<?> getsingletraineedetails(String zid) {
		
		System.out.println(zid);
		
		return new ResponseEntity<>(traineeRepository.getSingleTraineeDetails(zid),HttpStatus.OK);
	}


	@Override
	public ResponseEntity<?> checkLoginDetails(TraineeLogin traineeLogin) {
			
			if(traineeLogin.getZid() == null || traineeLogin.getPassword() ==null)
			{
				return PerformanceTrackerUtils.getResponseEntity("Given data is null",HttpStatus.NOT_FOUND);
			}
			
			if(traineeLogin.getZid() =="" || traineeLogin.getPassword() =="")
			{
				return PerformanceTrackerUtils.getResponseEntity("Given data is empty",HttpStatus.NOT_FOUND);
			}
			
			if(Pattern.matches("[Zz][0-9]{6}", traineeLogin.getZid()))
			{
				if(Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,16}$", traineeLogin.getPassword()))
				{
					
					Trainee original = traineeRepository.findByZid(traineeLogin.getZid());
					if(Objects.isNull(original))
					{
						return PerformanceTrackerUtils.getResponseEntity("Zid Doesn't exist Contact admin",HttpStatus.NOT_FOUND);
					}
					else {
						
						if(original.getPassword() == null)
						{
							return PerformanceTrackerUtils.getResponseEntity("Account Doesn't exist signup first",HttpStatus.NOT_FOUND);
						}
						
						System.out.println(original.getPassword());
						System.out.println(traineeLogin.getPassword());
						if(original.getPassword().equals(traineeLogin.getPassword()))
						{
							if(original.getStatus().equals("false"))
							{
								return PerformanceTrackerUtils.getResponseEntity("Please Verify your email",HttpStatus.UNAUTHORIZED);
							}
							
							return PerformanceTrackerUtils.getResponseEntity("Login Success",HttpStatus.OK);
							
						}
						else {
							return PerformanceTrackerUtils.getResponseEntity("Password is wrong",HttpStatus.OK);
						}
						
					}
					
				}
				else {
					return PerformanceTrackerUtils.getResponseEntity("Password must contain at least one digit,,atleast one lowercase,atleast one uppercase of at least 8 characters and a maximum of 16 characters",HttpStatus.NOT_FOUND);
				}
			}
			
				return PerformanceTrackerUtils.getResponseEntity("First letter must be z and next 6 numbers and maximum 7",HttpStatus.NOT_FOUND);
						
		}


	@Override
	public ResponseEntity<?> getAllTraineeDetails(String zid) {
		
		try
		{
			return new ResponseEntity<>(traineeRepository.getAllResultByZid(zid),HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return PerformanceTrackerUtils.getResponseEntity(PerformanceTrackerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
}
 