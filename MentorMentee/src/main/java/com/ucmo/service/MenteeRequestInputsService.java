package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.MenteeRequestInputs;
import com.ucmo.dto.Program;
import com.ucmo.dto.ProgramParticipant;
import com.ucmo.dto.ProgramRequest;

public interface MenteeRequestInputsService {
	
	public List<MenteeRequestInputs> getMenteeRequestInputsByRequests(List<ProgramRequest> requestList);
	public List<MenteeRequestInputs> getMenteeRequestInputsByPrograms(List<Program> programsList, int menteeId);
	public List<MenteeRequestInputs> getMenteeRequestInputsByParticipants(List<ProgramParticipant> participantsList);

}
