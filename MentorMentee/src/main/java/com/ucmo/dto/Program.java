package com.ucmo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROGRAM")
public class Program {
	
	@Id
	@Column(name="PROGRAM_ID")	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int programId;
	
	@Column(name="PROGRAM_NAME")
	private String programName;
	
	@Column(name="COURSE_ID")
	private int courseId;
	
	@Column(name="DURATION")
	private int duration;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="MENTOR_ID")
	private int mentorId;
	
	@Column(name="MENTOR_PROGRAM_NOTES")
	private String mentorProgramNotes;
	
	@Column(name="ALLOWED_NUMBER_OF_MENTEES")
	private int allowedNoOfMentees;
	
	@Column(name="ENROLLED_NUMBER_OF_MENTEES")
	private int enrolledNoOfMentees;

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

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	public String getMentorProgramNotes() {
		return mentorProgramNotes;
	}

	public void setMentorProgramNotes(String mentorProgramNotes) {
		this.mentorProgramNotes = mentorProgramNotes;
	}

	public int getAllowedNoOfMentees() {
		return allowedNoOfMentees;
	}

	public void setAllowedNoOfMentees(int allowedNoOfMentees) {
		this.allowedNoOfMentees = allowedNoOfMentees;
	}

	public int getEnrolledNoOfMentees() {
		return enrolledNoOfMentees;
	}

	public void setEnrolledNoOfMentees(int enrolledNoOfMentees) {
		this.enrolledNoOfMentees = enrolledNoOfMentees;
	}

	
	

}
