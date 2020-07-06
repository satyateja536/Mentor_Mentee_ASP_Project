package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.ProgramRequest;

public interface ProgramRequestService {
	
	public void addProgramRequest(ProgramRequest programRequest);
	public ProgramRequest updateProgramRequest(ProgramRequest programRequest);
	public List<ProgramRequest> getAllProgramRequests();
	public ProgramRequest getProgramRequest(int requestId);
	public void deleteProgramRequest(int requestId);
	public int getNoOfWaitingRequestsByProgram(int programId);
	public List<ProgramRequest> getAllWaitingRequestsByProgram(int programId);	
	public void updateRequestStatus(int requestId, String requestStatus);
	public List<ProgramRequest> getAllMenteeRequestsByStatus(int menteeId, String requestStatus);
	public List<ProgramRequest> getNonWaitingMenteeRequests(int menteeId);
	public List<ProgramRequest> getWaitingMenteeRequests(int menteeId);
	public List<ProgramRequest> getMenteeRequestsByProgramAndStatus(int menteeId, int programId, String requestStatus);
	public ProgramRequest populateProgramRequest(int menteeId, int programId, String menteeComments, String status);
	public String requestValidation(int menteeId, int programId);
	public void updateMenteeRequestsToClosed(List<ProgramRequest> menteeRequests);
	
}
