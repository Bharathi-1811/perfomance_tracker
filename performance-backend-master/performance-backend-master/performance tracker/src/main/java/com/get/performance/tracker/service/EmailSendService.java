package com.get.performance.tracker.service;



public interface EmailSendService {

	public void sendSimpleEmail(String toEmail, String body, String subject);

}
