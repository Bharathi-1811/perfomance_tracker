package com.get.performance.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.get.performance.tracker.entity.BatchTopicCombination;
import com.get.performance.tracker.wrapper.BatchTopicCombinationWrapper;



@Repository
public interface BatchTopicCombinationRepository extends JpaRepository<BatchTopicCombination,Long>{

	
	@Query(value="select batch_topic_id, batch_name, topic_name from batchtopiccombo natural join batch natural join topic", nativeQuery=true)
	public List<BatchTopicCombinationWrapper> getBatchTopicNames();
	
//	@Query(value="select batch_id,topic_id from batchtopiccombo where batch_topic_id=?1",nativeQuery=true)
//	public BatchTopicCombination getBatch
//	
	
	//getDashboardAllTopic
	@Query(value="select topic_id,topic_name from batchtopiccombo natural join topic where batch_id = ?1",nativeQuery=true)
	public List<Object> getDashboardAllTopics(Long batch_id);
	
	//getDashboardLineChart
	@Query(value="select retest_no, score, result from batchtopiccombo natural join upcomingtest natural join result where topic_id=?1 and zid=?2",nativeQuery=true)
	public List<Object> getScoreByTopicAndZid(Long topic_id,String zid);
	
	
}
