package com.get.performance.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.get.performance.tracker.entity.BatchTraineeCombination;
import com.get.performance.tracker.wrapper.BatchTraineeCombo;
@Repository
public interface BatchTraineeCombinationRepository extends JpaRepository<BatchTraineeCombination,Long> {

	@Query(value="select * from batchtraineecombo where batch_id=?1",nativeQuery = true)
	public List<BatchTraineeCombination> getBatchTraineeZidById(Long id);

//   @Query(value="select id, zid, name from signuptrainee", nativeQuery = true)
//   public List<Object[]> getAllBatchTrainee();
//
//	@Query(value="select bt_id,zid,name  from batchtraineecombo natural join signuptrainee order by bt_id",nativeQuery=true)
//	public List<> getBatchTraineeAllCustom();

	@Query(value="select * from batchtraineecombo natural join batch where zid=?1" , nativeQuery = true)
	public List<Object[]> getTraineeDashboard(String zid);
	
}
