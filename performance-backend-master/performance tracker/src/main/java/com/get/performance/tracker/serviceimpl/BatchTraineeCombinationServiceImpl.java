package com.get.performance.tracker.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.get.performance.tracker.entity.BatchTraineeCombination;
import com.get.performance.tracker.repository.BatchTraineeCombinationRepository;
import com.get.performance.tracker.repository.TraineeRepository;
import com.get.performance.tracker.service.BatchTraineeCombinationService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;
import com.get.performance.tracker.wrapper.TraineeList;

@Service
public class BatchTraineeCombinationServiceImpl implements BatchTraineeCombinationService{

	@Autowired
	TraineeRepository traineeRepository;
	
	@Autowired
	BatchTraineeCombinationRepository batchTraineeCombinationRepository;
	
	public ResponseEntity<?> getAllTrainees() {
		
		return new ResponseEntity<>(traineeRepository.getAllSearchTrainee(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> addAllTraineesToBatch(Long id, TraineeList[] traineesList) {
		
		List<BatchTraineeCombination> trainees = new ArrayList<>();
		
		if(traineesList.length==0)
		{
			return PerformanceTrackerUtils.getResponseEntity("please select atleast one student", HttpStatus.NOT_FOUND);
		}
		
		for(int i=0;i<traineesList.length;i++)
		{
			trainees.add(new BatchTraineeCombination(id,traineesList[i].getZid()));
		}
		
		return new ResponseEntity<>(batchTraineeCombinationRepository.saveAll(trainees),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllBatchTrainees() {
		
		return new ResponseEntity<>(batchTraineeCombinationRepository.findAll(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getDashboardBatch(String zid) {
		
		 
		return new ResponseEntity<>(batchTraineeCombinationRepository.getTraineeDashboard(zid),HttpStatus.OK);
	}


}
