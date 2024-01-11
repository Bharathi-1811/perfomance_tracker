package com.get.performance.tracker.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultWrapper {

	private Long rid;
	private String zid;
	private Integer score;
	private String result;
	
}
