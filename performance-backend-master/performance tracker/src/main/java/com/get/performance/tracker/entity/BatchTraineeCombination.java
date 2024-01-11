package com.get.performance.tracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="batchtraineecombo")
@Data
public class BatchTraineeCombination {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long btId;
	
	private long batchId;
	
	public BatchTraineeCombination(long batchId, String zid) {
		super();
		this.batchId = batchId;
		this.zid = zid;
	}

	public BatchTraineeCombination(long btId, long batchId, String zid) {
		super();
		this.btId = btId;
		this.batchId = batchId;
		this.zid = zid;
	}

	public BatchTraineeCombination() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String zid;
}
