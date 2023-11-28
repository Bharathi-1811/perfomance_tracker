package com.get.performance.tracker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.get.performance.tracker.entity.BatchTopicCombination;

public interface BatchTopicCombinationService {

	ResponseEntity<?> createCombination(BatchTopicCombination combination);

	ResponseEntity<?> getAllBatchTopicCombination();

	ResponseEntity<?> getBatchTopicCombinationById(Long id);

	ResponseEntity<?> updateBatchTopicCombination(Long id, BatchTopicCombination combination);

	ResponseEntity<?> DeleteBatchTopicCombinationById(Long combinationid);

	ResponseEntity<?> getDashboardAllTopic(Long id);

	ResponseEntity<?> getScoreByTopicId(Long id, String zid);

	

}
