package com.ucmo.dto;

public class MenteeProgramSession {	
	
	
	private Employee mentor;		
	
	private Program program;
	
	private Course course;
	
	private ProgramParticipant participant;	
	
	private int participantId;	
	
	private String mentorNotes;
	
	private String menteeNotes;
	
	private String sessionStatus;

	public Employee getMentor() {
		return mentor;
	}

	public void setMentor(Employee mentor) {
		this.mentor = mentor;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ProgramParticipant getParticipant() {
		return participant;
	}

	public void setParticipant(ProgramParticipant participant) {
		this.participant = participant;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
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

	public String getSessionStatus() {
		return sessionStatus;
	}

	public void setSessionStatus(String sessionStatus) {
		this.sessionStatus = sessionStatus;
	}

		

}
