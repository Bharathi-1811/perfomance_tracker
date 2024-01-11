package com.get.performance.tracker.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="batchtopiccombo")
@Data
@DynamicUpdate
public class BatchTopicCombination {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="combination_id")
	private long batchTopicId;
    private long batchId;
    private long topicId;
	
}
