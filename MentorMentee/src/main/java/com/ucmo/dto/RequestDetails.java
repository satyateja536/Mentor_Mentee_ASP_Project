package com.ucmo.dto;

public class RequestDetails {
	
	private int requestId;
	
	private int menteeId;
	
	private int programId;
	
	private String menteeName;
	
	private String menteeDesignation;
	
	private String manager;
	
	private String programName;
	
	private String courseLevel;
	
	private String courseGroup;
	
	private String menteeComments;
	
	private int noOfAvailableSlots;
	
	private int noOfRequests;
	
	private String requestStatus;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getMenteeId() {
		return menteeId;
	}

	public void setMenteeId(int menteeId) {
		this.menteeId = menteeId;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getMenteeName() {
		return menteeName;
	}

	public void setMenteeName(String menteeName) {
		this.menteeName = menteeName;
	}

	public String getMenteeDesignation() {
		return menteeDesignation;
	}

	public void setMenteeDesignation(String menteeDesignation) {
		this.menteeDesignation = menteeDesignation;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}

	public String getCourseGroup() {
		return courseGroup;
	}

	public void setCourseGroup(String courseGroup) {
		this.courseGroup = courseGroup;
	}

	public String getMenteeComments() {
		return menteeComments;
	}

	public void setMenteeComments(String menteeComments) {
		this.menteeComments = menteeComments;
	}

	public int getNoOfAvailableSlots() {
		return noOfAvailableSlots;
	}

	public void setNoOfAvailableSlots(int noOfAvailableSlots) {
		this.noOfAvailableSlots = noOfAvailableSlots;
	}

	public int getNoOfRequests() {
		return noOfRequests;
	}

	public void setNoOfRequests(int noOfRequests) {
		this.noOfRequests = noOfRequests;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}	
	
	

}
