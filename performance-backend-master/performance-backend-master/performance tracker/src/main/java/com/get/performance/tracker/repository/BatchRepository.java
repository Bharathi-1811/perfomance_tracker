package com.get.performance.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.get.performance.tracker.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long>{

}
