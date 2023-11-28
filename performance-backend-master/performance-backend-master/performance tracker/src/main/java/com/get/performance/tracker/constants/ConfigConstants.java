package com.get.performance.tracker.constants;

public class ConfigConstants 
{
	public final static String COMBINATION_TABLE = "";
	public final static String BATCH_TABLE = "";
	public final static String TOPIC_TABLE = "";
	public final static String COMBINATION_QUERY = "select * from " + COMBINATION_TABLE 
			+ " natural join " + BATCH_TABLE
			+ " natural join " + TOPIC_TABLE;
}
