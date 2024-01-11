package com.get.performance.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.get.performance.tracker.entity.Topic;
import com.get.performance.tracker.service.TopicService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
public class TopicController {

		@Autowired
		TopicService topicService;
		
		//create topic
		@PostMapping("/topic")
		public ResponseEntity<Topic> createTopic(@RequestBody Topic topic)
		{
				return topicService.createTopic(topic);			
		}
	
		//get all Topics
		@GetMapping("/topic")
		public ResponseEntity<List<Topic>> getAllTopic(){
			
				return topicService.getAllTopic();
		}
		
		//get topic by id
		@GetMapping("/topic/{id}")
		public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {

				return topicService.getTopicById(id);
		}
		
		//update topic by id
		@PutMapping("/topic/{id}")
		public ResponseEntity<String> updateTopic(@PathVariable Long id,@RequestBody Topic topic){
			
				return topicService.updateTopic(id,topic);
		}
		
		//delete topic by id
		@DeleteMapping("/topic/{id}")
		public ResponseEntity<String> DeleteTopicById(@PathVariable Long id)
		{
			return topicService.deleteTopic(id);
		}
			
}
