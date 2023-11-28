package com.get.performance.tracker.entity;



import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="batch")
@Data
@DynamicUpdate
public class Batch {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long batchId;
	
	@Column(name="batch_year")
	private String year;
	
	@Column(name="batch_name")
	@NotNull(message="Name shouldn't be Null")
	@NotEmpty(message="Name shouldn't be empty")
	private String name;
	
}
