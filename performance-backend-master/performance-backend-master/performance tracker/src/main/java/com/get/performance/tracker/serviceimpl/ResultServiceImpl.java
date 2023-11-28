package com.get.performance.tracker.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.get.performance.tracker.entity.Result;
import com.get.performance.tracker.repository.ResultRepository;
import com.get.performance.tracker.service.ResultService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;
import com.get.performance.tracker.wrapper.Piechart;
import com.get.performance.tracker.wrapper.ViewResult;

import lombok.extern.slf4j.Slf4j;

@Service

public class ResultServiceImpl implements ResultService{

	@Autowired
	ResultRepository resultRepository;
	
	@Override
	public ResponseEntity<?> getResultByTestId(Long testId) {
			
		try {
			return new ResponseEntity<>(resultRepository.getResultByTestId(testId),HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> getResultByRid(Long id) {
	
		try {
			Optional<Result> resultByRid = resultRepository.findById(id);
			
			if(resultByRid.isPresent())
			{
				return new ResponseEntity<>(resultByRid.get(),HttpStatus.OK); 
			}
			else {
				return PerformanceTrackerUtils.getResponseEntity("rid not exits",HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<?> updateResultByRid(Long id,Result result) {
		
		try
		{
			Optional<Result> actual = resultRepository.findById(id);
			if(actual.isPresent())
			{	
				Result act = actual.get();
				act.setZid(result.getZid());
				act.setScore(result.getScore());
				if(act.getScore()<75)
				{
					act.setResult("Fail");
				}
				else {
					act.setResult("Pass");
				}
				
				resultRepository.save(act);
				return PerformanceTrackerUtils.getResponseEntity("successfullyupdated", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("rid id doesnot exist",HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> viewResultByTestId(Long testId) {

		try {
			List<Result> result = resultRepository.getResultByTestId(testId);
			ArrayList<ViewResult> graph = new ArrayList<>();
			for(int i=0;i<result.size();i++)
			{	
				Integer colorValue = getColorValueBasedScore(result.get(i).getScore());
				
				graph.add(new ViewResult(result.get(i).getZid(),result.get(i).getScore(),colorValue));
				
			}
			
			return new ResponseEntity<List<ViewResult>>(graph,HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);

		
	}
	
	
	public Integer getColorValueBasedScore(Integer score)
	{
		Integer colorValue=0;
		
		if(score>=0 && score<=10)
		{
			colorValue = 1;
		}
		else if(score>=11 && score<=20)
		{
			colorValue = 2;
		}
		else if(score>=21 && score<=30)
		{
			colorValue = 3;
		}
		else if(score>=31 && score<=40)
		{
			colorValue = 4;
		}
		else if(score>=41 && score<=50)
		{
			colorValue = 5;
		}
		else if(score>=51 && score<=60)
		{
			colorValue = 6;
		}
		else if(score>=61 && score<=70)
		{
			colorValue = 7;
		}
		else if(score>=71 && score<=80)
		{
			colorValue = 8;
		}
		else if(score>=81 && score<=90)
		{
			colorValue = 9;
		}
		else if(score>=91 && score<=100)
		{
			colorValue = 10;
		}
		
		return colorValue;
	}

	@Override
	public ResponseEntity<?> ViewGraphByTestid(Long id) {

		Integer totalCount = resultRepository.getTraineesCountByTestId(id);
		
		Integer passedCount = resultRepository.getTraineesPassedCountByTestId(id);
		
		System.out.println(totalCount);
		System.out.println(passedCount);
		
		
		Integer passed = (int) Math.round((Double.valueOf(passedCount)/Double.valueOf(totalCount)*100) );
		Integer failed = 100 - passed;
		
		System.out.println(passed);
		System.out.println(failed);
		Piechart pie = new Piechart(passed, failed);
		
		
		return new ResponseEntity<>(pie, HttpStatus.OK);
		
	}
	

}
