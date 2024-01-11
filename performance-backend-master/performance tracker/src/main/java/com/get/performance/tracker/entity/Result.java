package com.get.performance.tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="result")
@NamedQuery(name = "Result.getZidAndScore",query = "SELECT r from Result r where r.testId=:testId")
@NamedQuery(name = "Result.updateScore",query = "Update Result r set r.score=:score where r.testId=:testId and r.zid=:zid")
@Data
public class Result {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long rid;
	private String zid;
	private Integer score;
	private String result;
	
	@JsonIgnore
	@ManyToOne( cascade={ CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} )
	@JoinColumn(name="testId")
	 public UpcomingTest testId;
	 	
	public Result(String zid, Integer score, String result) {
		super();
		this.zid = zid;
		this.score = score;
		this.result = result;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Result(String zid, Integer score, String result, UpcomingTest testId) {
		super();
		this.zid = zid;
		this.score = score;
		this.result = result;
		this.testId = testId;
	}

	
	 
	
}

