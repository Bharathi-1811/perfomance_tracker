package com.get.performance.tracker.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.get.performance.tracker.entity.Topic;
import com.get.performance.tracker.exception.ResourceNotFoundException;
import com.get.performance.tracker.repository.TopicRepository;
import com.get.performance.tracker.service.TopicService;
import com.get.performance.tracker.utils.PerformanceTrackerUtils;

@Service
public class TopicServiceImpl implements TopicService{

	
	@Autowired 
	TopicRepository topicRepository;

	@Override
	public ResponseEntity<Topic> createTopic(Topic topic) {
		try {
			return new ResponseEntity<>(topicRepository.save(topic),HttpStatus.CREATED);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<Topic>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Override
	public ResponseEntity<List<Topic>> getAllTopic() {
		try {
			return new ResponseEntity<>(topicRepository.findAll(),HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<List<Topic>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Topic> getTopicById(Long id) {
		
		try {
			Optional<Topic> topicById = topicRepository.findById(id);
			
			if(topicById.isPresent())
			{
				return new ResponseEntity<>(topicById.get(),HttpStatus.OK); 
			}
			else {
				throw new ResourceNotFoundException("Topic id not Exist :" + id);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<Topic>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@Override
	public ResponseEntity<String> updateTopic(Long id, Topic topic) {

		try
		{
			Optional<Topic> actual = topicRepository.findById(id);
			if(actual.isPresent())
			{	
				Topic act = actual.get();
				act.setTopicName(topic.getTopicName());
				topicRepository.save(act);
				return PerformanceTrackerUtils.getResponseEntity("successfullyupdated", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("Topic id doesnot exist",HttpStatus.OK);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> deleteTopic(Long id) {
	
		try {
			
			if(topicRepository.existsById(id))
			{
				topicRepository.deleteById(id);
				return new ResponseEntity<String>("",HttpStatus.OK);
			}
			else {
				throw new ResourceNotFoundException("Topic id not Exist :" + id);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	

}
