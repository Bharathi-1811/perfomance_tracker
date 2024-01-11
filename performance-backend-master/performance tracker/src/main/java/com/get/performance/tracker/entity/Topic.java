package com.get.performance.tracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="topic")
@Data
public class Topic {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long topicId;
	
	@Column(name="topicName")
	private String topicName;

	
}
