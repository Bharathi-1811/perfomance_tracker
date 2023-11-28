package com.get.performance.tracker.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.get.performance.tracker.entity.BatchTopicCombination;
import com.get.performance.tracker.entity.BatchTraineeCombination;
import com.get.performance.tracker.entity.Result;
import com.get.performance.tracker.entity.UpcomingTest;
import com.get.performance.tracker.repository.BatchTopicCombinationRepository;
import com.get.performance.tracker.repository.BatchTraineeCombinationRepository;
import com.get.performance.tracker.repository.ResultRepository;
import com.get.performance.tracker.repository.UpcomingTestRepository;
import com.get.performance.tracker.service.UpcomingTestService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;

@Service
public class UpcomingTestServiceImpl implements UpcomingTestService {

	@Autowired
	UpcomingTestRepository upcomRepository;

	// injecting BatchTopicCombinationRepository
	@Autowired
	BatchTopicCombinationRepository btComRepository;

	// injecting BatchTraineeCombinationRepository
	@Autowired
	BatchTraineeCombinationRepository batchTraineeComRepository;

	// result Repository
	@Autowired
	ResultRepository resultRepository;

	public ResponseEntity<?> createUpcoming(UpcomingTest upcomingTest) {
		try {
			
				UpcomingTest data = new UpcomingTest();
				data.setCombinationId(upcomingTest.getCombinationId());
				data.setSelectDate(upcomingTest.getSelectDate());
				// getting count of combinationId
				Long count = upcomRepository.getCountOfCombinationId(data.getCombinationId());
				if (count == 0) {
					// generating new testId
					Long testId = PerformanceTrackerUtils.generateNewTestId(data.getCombinationId());
					data.setTestId(testId);
					data.setRetestNo(upcomingTest.getRetestNo());
					// from combinationId to get batch id (details)
					Optional<BatchTopicCombination> bcCombo = btComRepository.findById(data.getCombinationId());
					if (bcCombo.isPresent()) {
						
						BatchTopicCombination bt = bcCombo.get();
						// from batchId to get list of trainees from that batch
						List<BatchTraineeCombination> lists = batchTraineeComRepository
								.getBatchTraineeZidById(bt.getBatchId());

						// create list of results and
						ArrayList<Result> results = new ArrayList<>();
						for (int i = 0; i < lists.size(); i++) {
							
							results.add(new Result(lists.get(i).getZid(), 0, "Fail", data));
						
						}
						data.setResult(results);
						return new ResponseEntity<>(upcomRepository.save(data), HttpStatus.CREATED);
					} 
					else 
					{
					
						return new ResponseEntity<>("BatchTopicCOmbo id not Exist :", HttpStatus.NOT_FOUND);
					}
					
//					return new ResponseEntity<>(upcomRepository.save(data),HttpStatus.CREATED);
				} else {
					
					Long testId = upcomRepository.getFirstTestId(data.getCombinationId());
					Long incremented = PerformanceTrackerUtils.incrementOldTestId(testId, count);
					data.setTestId(incremented);
					data.setRetestNo(upcomingTest.getRetestNo());
						
					List<Result>previousTestFailedList = resultRepository.getFailedTraineesList(incremented-1);
					
					// create list of results and again generating new list of students and saving to result table
					ArrayList<Result> results1 = new ArrayList<>();
					for (int i = 0; i < previousTestFailedList.size(); i++) {
						results1.add(new Result(previousTestFailedList.get(i).getZid(), 0, "Fail", data));
					}
				
					data.setResult(results1);
					return new ResponseEntity<>(upcomRepository.save(data), HttpStatus.CREATED);
				}
		} 
		catch (Exception ex) {
			
			ex.printStackTrace();
		
		}
		
		return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<?> getRetestNo(Long cid) {
		try {
			Long count = upcomRepository.getCountOfCombinationId(cid);
			return new ResponseEntity<>(count, HttpStatus.CREATED);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("Something Went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<UpcomingTest>> getAllUpcoming() {
		try {
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			String dtime = dtf.format(now);
			dtime = dtime.substring(0, 10) + 'T' + dtime.substring(11, 16);
//			System.out.println(dtime);
//			String datetime = dtime;
			return new ResponseEntity<List<UpcomingTest>>(upcomRepository.getUpcomingTest(dtime), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<List<UpcomingTest>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> getUpcomingById(Long testId) {

		try {
			Optional<UpcomingTest> combinationById = upcomRepository.findById(testId);

			if (combinationById.isPresent()) {
				return new ResponseEntity<>(combinationById.get(), HttpStatus.OK);
			} else {
//				throw new ResourceNotFoundException("Test id not Exist :" + batchid);
				return PerformanceTrackerUtils.getResponseEntity("Test id not Exist", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	
	@Override
	public ResponseEntity<?> upcomingUpdate(Long batchid, UpcomingTest upcomingTest) {

		try {
			Optional<UpcomingTest> actual = upcomRepository.findById(batchid);
			if (actual.isPresent()) {
				UpcomingTest act = actual.get();

				act.setCombinationId(upcomingTest.getCombinationId());
				act.setRetestNo(upcomingTest.getRetestNo());
				act.setSelectDate(upcomingTest.getSelectDate());
				upcomRepository.save(act);
				return PerformanceTrackerUtils.getResponseEntity("Successfully updated", HttpStatus.OK);
			} else {
				return PerformanceTrackerUtils.getResponseEntity("Test id not present", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

//
	@Override
	public ResponseEntity<?> upcomingDelete(Long testId) {

		try {

			if (upcomRepository.existsById(testId)) {
				upcomRepository.deleteById(testId);
				return PerformanceTrackerUtils.getResponseEntity("Successfully deleted", HttpStatus.OK);
			} else {
				return PerformanceTrackerUtils.getResponseEntity("Test id not present", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<List<UpcomingTest>> getAllPast() {

		try {
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			String dtime = dtf.format(now);
			dtime = dtime.substring(0, 10) + 'T' + dtime.substring(11, 16);
			//System.out.println(dtime);
			//String datetime = dtime;
			return new ResponseEntity<List<UpcomingTest>>(upcomRepository.getPastTest(dtime), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<List<UpcomingTest>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<UpcomingTest>> getOnGoing() {
		
		try {
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			String dtime = dtf.format(now);
			dtime = dtime.substring(0, 10) + 'T' + dtime.substring(11, 16);
			//System.out.println(dtime);
			//String datetime = dtime;
			return new ResponseEntity<List<UpcomingTest>>(upcomRepository.getOnGoingTest(dtime), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<List<UpcomingTest>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
