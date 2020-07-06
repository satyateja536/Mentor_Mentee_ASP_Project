package com.ucmo.dto;

public class MenteeRequestInputs {
	
	private int requestId;
	
	private int participantSessionId;
	
	private int programId;	
	
	private String programName;
	
	private String mentorName;
	
	private int programDuration;
	
	private String requestStatus;	

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}	

	public int getParticipantSessionId() {
		return participantSessionId;
	}

	public void setParticipantSessionId(int participantSessionId) {
		this.participantSessionId = participantSessionId;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public int getProgramDuration() {
		return programDuration;
	}

	public void setProgramDuration(int programDuration) {
		this.programDuration = programDuration;
	}
	
	
	

}
