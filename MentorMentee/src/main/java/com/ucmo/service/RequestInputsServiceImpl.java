package com.ucmo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dto.Program;
import com.ucmo.dto.RequestInputs;

@Service
@Transactional
public class RequestInputsServiceImpl implements RequestInputsService {	

	
	@Autowired
	private ProgramParticipantService programParticipantService;
	
	@Autowired
	private ProgramRequestService programRequestService;

	

	@Transactional
	public List<RequestInputs> getAllRequestInputs(List<Program> programsList) {
		
		List<RequestInputs> requestInputsList = new ArrayList<RequestInputs>();
		
		for(Program program: programsList) {
			RequestInputs requestInput = new RequestInputs();
			int programId = program.getProgramId();				
			int noOfRequests = programRequestService.getNoOfWaitingRequestsByProgram(programId);
			requestInput.setProgramId(programId);
			requestInput.setProgramName(program.getProgramName());
			requestInput.setNoOfRequests(noOfRequests);
			requestInputsList.add(requestInput);
		}
		
		return requestInputsList;
		
	}
	
	@Transactional
	public List<RequestInputs> getAllSessionInputs(List<Program> programsList) {
		
		List<RequestInputs> sessionInputsList = new ArrayList<RequestInputs>();
		
		for(Program program: programsList) {
			RequestInputs requestInput = new RequestInputs();
			int programId = program.getProgramId();				
			int noOfRequests = programParticipantService.getNoOfActiveParticipantsByProgram(programId);
			requestInput.setProgramId(programId);
			requestInput.setProgramName(program.getProgramName());
			requestInput.setNoOfRequests(noOfRequests);
			sessionInputsList.add(requestInput);
		}
		
		return sessionInputsList;
		
	}

	@Transactional
	public List<RequestInputs> getAllHistoryInputs(List<Program> programsList) {
		
		List<RequestInputs> historyInputsList = new ArrayList<RequestInputs>();
		
		for(Program program: programsList) {
			RequestInputs requestInput = new RequestInputs();
			int programId = program.getProgramId();				
			int noOfRequests = programParticipantService.getNoOfInactiveParticipantsByProgram(programId);
			requestInput.setProgramId(programId);
			requestInput.setProgramName(program.getProgramName());
			requestInput.setNoOfRequests(noOfRequests);
			historyInputsList.add(requestInput);
		}
		
		return historyInputsList;
		
	}
	
	
}
