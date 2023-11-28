package com.get.performance.tracker.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchTopicCombinationWrapper {

	public long batchTopicId;
	
	public String name;
	
	public String topicName;
}
