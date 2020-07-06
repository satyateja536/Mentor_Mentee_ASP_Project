package com.ucmo.service;

import com.ucmo.dto.EmailNotification;
import com.ucmo.dto.Employee;
import com.ucmo.dto.Program;

public interface EmailNotificationService {
		
	public String sendNotification(EmailNotification emailNotification) throws Exception;
	public EmailNotification populateEmailNotificationForClosedMentor(String menteeMailIds, String subject, Employee mentor, Program program);
	public EmailNotification populateEmailNotificationForClosedMentee(String mentorMailId, String subject, Employee mentee, Program program);
	public EmailNotification populateEmailNotificationForClosedUser(String mailId, String subject, Employee employee);
}
