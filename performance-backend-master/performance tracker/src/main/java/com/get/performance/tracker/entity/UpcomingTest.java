package com.get.performance.tracker.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="upcomingtest")
@Data public class UpcomingTest {

	@Id
	public long testId;

	public long combinationId;
	
	public long retestNo;

	public String selectDate;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="testId",cascade = CascadeType.ALL )
	public List<Result>result;
}
