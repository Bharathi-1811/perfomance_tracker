package com.get.performance.tracker.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.get.performance.tracker.entity.Trainee;
import com.get.performance.tracker.wrapper.SearchTrainee;

import jakarta.transaction.Transactional;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Long>{

	 Trainee findByEmailId(@Param("email") String email);
	 Trainee findByZid(@Param("zid") String zid);
	 

	@Modifying
	@Transactional
	Integer updateSignupForm(@Param("name") String name,@Param("mobileNumber") String mobileNumber,@Param("password") String password,@Param("gender") String gender,@Param("zid") String zid);
	
	String getTraineeEmail(@Param("zid")String zid);
	
	@Modifying
	@Transactional
	Integer updateTraineeStatus(@Param("status") String status,@Param("zid") String zid);
	
	
	//search trainee id,zid,name selecting query
	 @Query(value="select id, zid, name from signuptrainee", nativeQuery = true)
	  public List<SearchTrainee> getAllSearchTrainee();
	
	 //getsingletraineedetails
	 @Query(value="select  result,score,zid,combination_id,retest_no,batch_name,topic_name  from result natural join upcomingtest natural join batchtopiccombo natural join batch natural join topic where zid=?1", nativeQuery = true)
	  public List<Object> getSingleTraineeDetails(String zid);
	
	 
	 @Query(value="select select_date,topic_name,retest_no,score,result from result natural join upcomingtest natural join batchtopiccombo natural join topic where zid=?1",nativeQuery=true)
	 public List<Object> getAllResultByZid(String zid);
	 
	 
	//find by zid function but return TraineeUserDetailsService
//	TraineeUserDetailsService findByZidMethod(@Param("zid") String zid);
}
