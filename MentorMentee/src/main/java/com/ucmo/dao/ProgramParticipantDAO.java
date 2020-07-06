package com.ucmo.dao;

import java.util.List;

import com.ucmo.dto.ProgramParticipant;

public interface ProgramParticipantDAO {
	
	public void addProgramParticipant(ProgramParticipant programParticipant);
	public ProgramParticipant updateProgramParticipant(ProgramParticipant programParticipant);
	public List<ProgramParticipant> getAllProgramParticipants();
	public ProgramParticipant getProgramParticipant(int participantId);
	public void deleteProgramParticipant(int participantId);
	public List<ProgramParticipant> getAllParticipantsByProgramAndStatus(int programId, String participationStatus);
	public ProgramParticipant getParticipantByProgramAndStatus(int programId, int menteeId, String participationStatus);
	public List<ProgramParticipant> getAllParticipantsByMenteeAndStatus(int menteeId, String participationStatus);
	public List<ProgramParticipant> getAllParticipantsByMentee(int menteeId);

}
