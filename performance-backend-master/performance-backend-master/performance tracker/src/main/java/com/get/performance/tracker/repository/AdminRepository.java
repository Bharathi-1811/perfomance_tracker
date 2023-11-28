package com.get.performance.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.get.performance.tracker.entity.Admin;
import com.get.performance.tracker.entity.Trainee;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{

	Admin findByZid(@Param("zid") String zid);
}
