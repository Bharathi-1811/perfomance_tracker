package com.get.performance.tracker.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.get.performance.tracker.entity.Batch;
import com.get.performance.tracker.exception.ResourceNotFoundException;
import com.get.performance.tracker.repository.BatchRepository;
import com.get.performance.tracker.service.BatchService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	BatchRepository batchRepository;

	@Override
	public ResponseEntity<?> createBatch(Batch batch) {
		try {
			return new ResponseEntity<>(batchRepository.save(batch), HttpStatus.CREATED);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<List<Batch>> getAllBatch() {
		try {
			return new ResponseEntity<>(batchRepository.findAll(), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<List<Batch>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> getBatchById(Long id) {

		try {
			Optional<Batch> combinationById = batchRepository.findById(id);

			if (combinationById.isPresent()) {
				return new ResponseEntity<>(combinationById.get(), HttpStatus.OK);
			} else {
				return PerformanceTrackerUtils.getResponseEntity("batch id is not present",HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> updateBatch(Long id, Batch batch) {

		try {
			Optional<Batch> actual = batchRepository.findById(id);
			if (actual.isPresent()) {
				Batch act = actual.get();
				act.setBatchId(batch.getBatchId());
				act.setName(batch.getName());
				act.setYear(batch.getYear());
				return new ResponseEntity<>(batchRepository.save(act), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(" Batch id doesnot exist", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> deleteBatchById(Long id) {

		try {

			if (batchRepository.existsById(id)) {
				batchRepository.deleteById(id);
				return PerformanceTrackerUtils.getResponseEntity("Successfully deleted", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(" Batch id doesnot exist", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
