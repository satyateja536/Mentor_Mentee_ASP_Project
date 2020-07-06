package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.Program;
import com.ucmo.dto.ProgramParticipant;

public interface ProgramParticipantService {
	
	public void addProgramParticipant(ProgramParticipant programParticipant);
	public ProgramParticipant updateProgramParticipant(ProgramParticipant programParticipant);
	public List<ProgramParticipant> getAllProgramParticipants();
	public ProgramParticipant getProgramParticipant(int participantId);
	public void deleteProgramParticipant(int participantId);
	public ProgramParticipant getParticipantByProgramAndStatus(int programId, int menteeId, String participationStatus);
	public List<ProgramParticipant> getAllParticipantsByProgramAndStatus(int programId, String participationStatus);
	public int getNoOfActiveParticipantsByProgram(int programId);
	public int getNoOfInactiveParticipantsByProgram(int programId);
	public ProgramParticipant populateNewParticipant(Program program, int menteeId);
	public List<ProgramParticipant> getAllParticipantsByMenteeAndStatus(int menteeId, String participationStatus);
	public void updateParticipantsStatusToInactive(List<ProgramParticipant> participants);
	public List<ProgramParticipant> getAllParticipantsByMentee(int menteeId);
	public void updateParticipantsStatusToClosed(List<ProgramParticipant> participants);

}
