package com.ucmo.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class EmailNotification {

	
	private String[] emailToRecipient;
	
	
	private String emailSubject;
	
	
	private String emailMessage;

	private CommonsMultipartFile attachFileObj;

	public String[] getEmailToRecipient() {
		return emailToRecipient;
	}

	public void setEmailToRecipient(String[] emailToRecipient) {
		this.emailToRecipient = emailToRecipient;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public CommonsMultipartFile getAttachFileObj() {
		return attachFileObj;
	}

	public void setAttachFileObj(CommonsMultipartFile attachFileObj) {
		this.attachFileObj = attachFileObj;
	}	
		
	

}
