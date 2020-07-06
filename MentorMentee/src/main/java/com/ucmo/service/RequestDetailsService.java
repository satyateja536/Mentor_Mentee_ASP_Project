package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.ProgramParticipant;
import com.ucmo.dto.RequestDetails;

public interface RequestDetailsService {
	
	public RequestDetails populateRequestDetails(int requestId, int menteeId, int programId);
	public List<RequestDetails> 
	getReqDetailsFromParticipants(List<ProgramParticipant> programParticipantList, int programId, String sessionStatus);
	

}
