package com.get.performance.tracker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.get.performance.tracker.entity.Topic;



public interface TopicService {

	ResponseEntity<List<Topic>> getAllTopic();

	ResponseEntity<Topic> createTopic(Topic topic);

	ResponseEntity<Topic> getTopicById(Long id);

	ResponseEntity<String> updateTopic(Long id, Topic topic);

	ResponseEntity<String> deleteTopic(Long id); 

	
}
