package com.ucmo.dao;

import java.util.List;

import com.ucmo.dto.ProgramRequest;

public interface ProgramRequestDAO {
	
	public void addProgramRequest(ProgramRequest programRequest);
	public ProgramRequest updateProgramRequest(ProgramRequest programRequest);
	public List<ProgramRequest> getAllProgramRequests();
	public ProgramRequest getProgramRequest(int requestId);
	public void deleteProgramRequest(int requestId);
	public List<ProgramRequest> getAllRequestsByProgram(int programId, String requestStatus);
	public List<ProgramRequest> getAllMenteeRequestsByStatus(int menteeId, String requestStatus);
	public List<ProgramRequest> getMenteeRequestsByProgramAndStatus(int menteeId, int programId, String requestStatus);
	public List<ProgramRequest> getNonWaitingMenteeRequests(int menteeId);
}
