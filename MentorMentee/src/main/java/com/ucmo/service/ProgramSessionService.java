package com.ucmo.service;

import com.ucmo.dto.ProgramSession;

public interface ProgramSessionService {
	
	public ProgramSession getProgramSession(int menteeId, int programId, String sessionStatus);
	
	/*
	 * public void addProgramRequest(ProgramRequest programRequest); public
	 * ProgramRequest updateProgramRequest(ProgramRequest programRequest); public
	 * List<ProgramRequest> getAllProgramRequests(); public ProgramRequest
	 * getProgramRequest(int requestId); public void deleteProgramRequest(int
	 * requestId); public int getNoOfWaitingRequestsByProgram(int programId); public
	 * List<ProgramRequest> getAllWaitingRequestsByProgram(int programId); public
	 * void updateRequestStatus(int requestId, String requestStatus);
	 */

}
