package com.ucmo.dto;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROGRAM_PARTICIPANT")
public class ProgramParticipant {
	
	@Id
	@Column(name="PARTICIPANT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int participantId;
	
	@Column(name="PROGRAM_ID")	
	private int programId;
	
	@Column(name="MENTEE_ID")	
	private int menteeId;
	
	@Column(name="MENTOR_NOTES")
	private String mentorNotes;
	
	@Column(name="MENTEE_NOTES")
	private String menteeNotes;
	
	@Column(name="COURSE_COMPLETION_STATUS")
	private String courseCompletionStatus;
	
	@Column(name="PARTICIPATION_STATUS")
	private String participationStatus;
	
	@Column(name="PROGRAM_DURATION")
	private int programDuration;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;	
	

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
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

	public String getMentorNotes() {
		return mentorNotes;
	}

	public void setMentorNotes(String mentorNotes) {
		this.mentorNotes = mentorNotes;
	}

	public String getMenteeNotes() {
		return menteeNotes;
	}

	public void setMenteeNotes(String menteeNotes) {
		this.menteeNotes = menteeNotes;
	}

	public String getCourseCompletionStatus() {
		return courseCompletionStatus;
	}

	public void setCourseCompletionStatus(String courseCompletionStatus) {
		this.courseCompletionStatus = courseCompletionStatus;
	}

	public String getParticipationStatus() {
		return participationStatus;
	}

	public void setParticipationStatus(String participationStatus) {
		this.participationStatus = participationStatus;
	}	

	public int getProgramDuration() {
		return programDuration;
	}

	public void setProgramDuration(int programDuration) {
		this.programDuration = programDuration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
