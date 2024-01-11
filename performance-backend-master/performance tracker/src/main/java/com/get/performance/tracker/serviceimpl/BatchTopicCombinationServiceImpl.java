package com.get.performance.tracker.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.get.performance.tracker.entity.BatchTopicCombination;
import com.get.performance.tracker.repository.BatchTopicCombinationRepository;
import com.get.performance.tracker.service.BatchTopicCombinationService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;

@Service
public class BatchTopicCombinationServiceImpl implements BatchTopicCombinationService {

	@Autowired
	BatchTopicCombinationRepository combinationRepository;

	@Override
	public ResponseEntity<?> createCombination(BatchTopicCombination combination) {

		try {
			return new ResponseEntity<>(combinationRepository.save(combination), HttpStatus.CREATED);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("some went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> getAllBatchTopicCombination() {

		try {
//			return new ResponseEntity<List<BatchTopicCombinationWrapper>>(combinationRepository.getBatchTopicNames(),HttpStatus.OK);
			return new ResponseEntity<List<BatchTopicCombination>>(combinationRepository.findAll(), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> getBatchTopicCombinationById(Long id) {

		try {
			Optional<BatchTopicCombination> topicById = combinationRepository.findById(id);

			if (topicById.isPresent()) {
				return new ResponseEntity<>(topicById.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Topic id not Exist :" + id, HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> updateBatchTopicCombination(Long id, BatchTopicCombination combination) {

		try {
			Optional<BatchTopicCombination> actual = combinationRepository.findById(id);
			if (actual.isPresent()) {
				
				BatchTopicCombination org = actual.get();
				org.setBatchId(combination.getBatchId());
				org.setTopicId(combination.getTopicId());
				combinationRepository.save(org);
				return PerformanceTrackerUtils.getResponseEntity("Successfully updated", HttpStatus.OK);
			
			} else {
				return new ResponseEntity<>("Topic id doesnot exist", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> DeleteBatchTopicCombinationById(Long id) {

		try {

			if (combinationRepository.existsById(id)) {
				combinationRepository.deleteById(id);
				return PerformanceTrackerUtils.getResponseEntity("Successfully deleted", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("combination id not Exist :" + id, HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<?> getDashboardAllTopic(Long id) {
		try {
			return new ResponseEntity<>(combinationRepository.getDashboardAllTopics(id),HttpStatus.OK);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

		
	}

	@Override
	public ResponseEntity<?> getScoreByTopicId(Long id, String zid) {
		
		try
		{
			return new ResponseEntity<>(combinationRepository.getScoreByTopicAndZid(id, zid),HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
