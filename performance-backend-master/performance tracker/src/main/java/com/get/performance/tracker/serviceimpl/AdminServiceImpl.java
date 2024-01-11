package com.get.performance.tracker.serviceimpl;

import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.get.performance.tracker.entity.Admin;
import com.get.performance.tracker.entity.Trainee;
import com.get.performance.tracker.repository.AdminRepository;
import com.get.performance.tracker.service.AdminService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;
import com.get.performance.tracker.wrapper.TraineeLogin;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public ResponseEntity<?> checkLoginDetails(TraineeLogin adminLogin) {
		
		if(adminLogin.getZid() == null || adminLogin.getPassword() ==null)
		{
			return PerformanceTrackerUtils.getResponseEntity("Given data is null",HttpStatus.NOT_FOUND);
		}
		
		if(adminLogin.getZid() =="" || adminLogin.getPassword() =="")
		{
			return PerformanceTrackerUtils.getResponseEntity("Given data is empty",HttpStatus.NOT_FOUND);
		}
		
		if(Pattern.matches("[Zz][0-9]{6}", adminLogin.getZid()))
		{
			if(Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,16}$", adminLogin.getPassword()))
			{
				
				Admin original = adminRepository.findByZid(adminLogin.getZid());
				if(Objects.isNull(original))
				{
					return PerformanceTrackerUtils.getResponseEntity("Zid Doesn't exist",HttpStatus.NOT_FOUND);
				}
				else {
					
					if(original.getPassword().equals(adminLogin.getPassword()))
					{
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

}
