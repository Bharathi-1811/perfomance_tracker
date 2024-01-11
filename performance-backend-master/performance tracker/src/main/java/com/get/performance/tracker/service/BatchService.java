package com.get.performance.tracker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.get.performance.tracker.entity.Batch;

public interface BatchService {

	ResponseEntity<?> createBatch(Batch batch);

	ResponseEntity<List<Batch>> getAllBatch();

	ResponseEntity<?> getBatchById(Long id);

	ResponseEntity<?> updateBatch(Long id, Batch batch);

	ResponseEntity<?> deleteBatchById(Long id);

}
