package com.ucmo.service;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ucmo.dto.EmailNotification;
import com.ucmo.dto.Employee;
import com.ucmo.dto.Program;

@Service
@Transactional
public class EmailNotificationServiceImpl implements EmailNotificationService{

	static String[] emailToRecipient; 
	static String emailSubject;
	static String emailMessage;
	static final String emailFromRecipient = "info.mentormentee@yahoo.com";
	
	@Autowired
	private JavaMailSender mailSenderObj;
	

	
	public String sendNotification(EmailNotification emailNotification) throws Exception {
		
		emailSubject = emailNotification.getEmailSubject();
		emailMessage = emailNotification.getEmailMessage();
		emailToRecipient = emailNotification.getEmailToRecipient();
		
		System.out.println("Inside Send Notification Method");
		System.out.println("Subject: "+emailSubject);
		System.out.println("Message: "+emailMessage);
		System.out.println("to: "+emailToRecipient.toString());
		 
		final CommonsMultipartFile attachFileObj = emailNotification.getAttachFileObj();
		
		mailSenderObj.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
				//mimeMsgHelperObj.setTo(emailToRecipient);
				mimeMsgHelperObj.setTo(emailToRecipient);
				mimeMsgHelperObj.setFrom(emailFromRecipient);				
				mimeMsgHelperObj.setText(emailMessage);
				
				mimeMsgHelperObj.setSubject(emailSubject);

				// Determine If There Is An File Upload. If Yes, Attach It To The Client Email				
				if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals(""))) {
					System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
					mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() {					
						public InputStream getInputStream() throws IOException {
							return attachFileObj.getInputStream();
						}
					});
				} else {
					System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
				}
			}
		});
		
		return null;
	}
	
	public EmailNotification populateEmailNotificationForClosedMentor(String menteeMailIds, String subject, Employee mentor, Program program) {
		
		System.out.println("Inside Close Mentor method Notification Service");
		System.out.println("MailIds: "+menteeMailIds);
		
		EmailNotification emailNotification = new EmailNotification();
		
		if(menteeMailIds.length() > 0) {
			menteeMailIds = menteeMailIds.substring(0, menteeMailIds.length()-1);
		}
		
		String[] toMailIds = menteeMailIds.split(";");
		
		String emailMessage = "The program "+program.getProgramName()+" is closed. For any further information please contact"
				+ "the mentor."
				+ "\n Mentor Details: \n"+ "Email: "+mentor.getEmail()+" \n Phone: "+mentor.getPhone();
		
		emailNotification.setEmailToRecipient(toMailIds);
		emailNotification.setEmailSubject(subject);
		emailNotification.setEmailMessage(emailMessage);
		
		
		return emailNotification;
	}
	
	public EmailNotification populateEmailNotificationForClosedMentee(String mentorMailId, String subject, Employee mentee, Program program) {
		
		EmailNotification emailNotification = new EmailNotification();		
		
		String[] toMailIds = mentorMailId.split(";");
		
		String emailMessage = "Mentee "+mentee.getEmployeeName()+" has left the program "+program.getProgramName()+". For any further information please contact"
				+ "the mentee."
				+ "\n Mentee Details: \n"+ "Email: "+mentee.getEmail()+" \n Phone: "+mentee.getPhone();
		
		emailNotification.setEmailToRecipient(toMailIds);
		emailNotification.setEmailSubject(subject);
		emailNotification.setEmailMessage(emailMessage);
		
		
		return emailNotification;
	}
	
	public EmailNotification populateEmailNotificationForClosedUser(String mailId, String subject, Employee employee) {
		
		EmailNotification emailNotification = new EmailNotification();		
		
		String[] toMailId = mailId.split(";");
		
		String emailMessage = "Hi "+employee.getEmployeeName()+", your Mentor Mentee application account has been terminated.";
		
		emailNotification.setEmailToRecipient(toMailId);
		emailNotification.setEmailSubject(subject);
		emailNotification.setEmailMessage(emailMessage);
		
		
		return emailNotification;
	}

}
