package com.get.performance.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.get.performance.tracker.entity.UpcomingTest;

@Repository
public interface UpcomingTestRepository extends JpaRepository<UpcomingTest,Long>{

	@Query(value="select COUNT(combination_id) from upcomingtest where combination_id=?1", nativeQuery=true)
	public Long getCountOfCombinationId(Long id);

	@Query(value="select test_id from upcomingtest where combination_id =?1 limit 1", nativeQuery=true)
	public Long getFirstTestId(Long id);
	
	@Query(value="select * from upcomingtest where select_date > ?1",nativeQuery=true)
	public List<UpcomingTest> getUpcomingTest(String date);
	
	@Query(value="select * from upcomingtest where select_date < ?1",nativeQuery=true)
	public List<UpcomingTest> getPastTest(String date);
	
	@Query(value="select * from upcomingtest where select_date = ?1 ",nativeQuery=true)
	public List<UpcomingTest> getOnGoingTest(String date);
	
}
