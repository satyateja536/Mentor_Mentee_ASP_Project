package com.ucmo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROGRAM_REQUEST")
public class ProgramRequest {
	
	@Id
	@Column(name="REQUEST_ID")	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int requestId;
	
	@Column(name="PROGRAM_ID")	
	private int programId;
	
	@Column(name="MENTEE_ID")	
	private int menteeId;
	
	@Column(name="REQUEST_STATUS")
	private String requestStatus;
	
	@Column(name="MENTEE_COMMENTS")
	private String menteeComments;
	
	@Column(name="REQUESTED_DATE")
	private Date requestedDate;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public int getMenteeId() {
		return menteeId;
	}

	public void setMenteeId(int menteeId) {
		this.menteeId = menteeId;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getMenteeComments() {
		return menteeComments;
	}

	public void setMenteeComments(String menteeComments) {
		this.menteeComments = menteeComments;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}	
	
	

}
