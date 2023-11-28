package com.get.performance.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.get.performance.tracker.entity.Result;

import jakarta.transaction.Transactional;

@Repository
public interface ResultRepository extends JpaRepository <Result, Long>{

	public  List<Result> getZidAndScore(Long testId);
	
	@Modifying
	@Transactional
	public  Integer updateScore(Integer score,Long testId,String zid);

	
	//Native query for retrieve who are all failed
	@Query(value="select * from result where score<75 and test_id=?1",nativeQuery=true)
	public List<Result>getFailedTraineesList(Long testId);
	
	//native query for retrieving based on testId
	@Query(value="select * from result where test_id=?1",nativeQuery=true)
	public List<Result> getResultByTestId(Long testId);
	
	//native query for retrieving total trainees
	@Query(value="select count(*) from result where test_id=?1",nativeQuery=true)
	public Integer getTraineesCountByTestId(Long testId);
	
	//native query for retrieving total passed trainees count
	@Query(value="select count(*) from result where test_id=?1 and score>=75",nativeQuery=true)
	public Integer getTraineesPassedCountByTestId(Long testId);

	
	
}
