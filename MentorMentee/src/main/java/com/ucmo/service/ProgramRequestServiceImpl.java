package com.ucmo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dao.ProgramRequestDAO;
import com.ucmo.dto.ProgramRequest;

@Service
@Transactional
public class ProgramRequestServiceImpl implements ProgramRequestService {
	
	@Autowired
	private ProgramRequestDAO programRequestDAO;
	
	public void setProgramRequestDAO(ProgramRequestDAO programRequestDAO) {
		this.programRequestDAO = programRequestDAO;
	}

	@Transactional
	public void addProgramRequest(ProgramRequest programRequest) {
		programRequestDAO.addProgramRequest(programRequest);		
	}

	@Transactional
	public ProgramRequest updateProgramRequest(ProgramRequest programRequest) {
		 return programRequestDAO.updateProgramRequest(programRequest);
		
	}

	@Transactional
	public List<ProgramRequest> getAllProgramRequests() {
		return programRequestDAO.getAllProgramRequests();
	}

	@Transactional
	public ProgramRequest getProgramRequest(int requestId) {
		return programRequestDAO.getProgramRequest(requestId);
	}

	@Transactional
	public void deleteProgramRequest(int requestId) {
		programRequestDAO.deleteProgramRequest(requestId);		
	}
	
	@Transactional
	public List<ProgramRequest> getAllMenteeRequestsByStatus(int menteeId, String requestStatus){
		return programRequestDAO.getAllMenteeRequestsByStatus(menteeId, requestStatus);
	}
	
	@Transactional
	public List<ProgramRequest> getNonWaitingMenteeRequests(int menteeId){
		return programRequestDAO.getNonWaitingMenteeRequests(menteeId);
	}
	
	@Transactional
	public List<ProgramRequest> getMenteeRequestsByProgramAndStatus(int menteeId, int programId, String requestStatus){
		return programRequestDAO.getMenteeRequestsByProgramAndStatus(menteeId, programId, requestStatus);
	}

	@Transactional
	public int getNoOfWaitingRequestsByProgram(int programId) {
		
		int n = 0;
		
		String requestStatus = "Waiting";
		List<ProgramRequest> requestList = programRequestDAO.getAllRequestsByProgram(programId, requestStatus);
		if(!requestList.isEmpty()) {
			n = requestList.size();
		}
		
		return n;
	}
	
	@Transactional
	public List<ProgramRequest> getAllWaitingRequestsByProgram(int programId) {
		
				
		String requestStatus = "Waiting";
		
		List<ProgramRequest> requestList;
		requestList = programRequestDAO.getAllRequestsByProgram(programId, requestStatus);
		
		
		return requestList;
	}		
	
	public void updateRequestStatus(int requestId, String requestStatus) {
		
		ProgramRequest pr = programRequestDAO.getProgramRequest(requestId);
		
		pr.setRequestStatus(requestStatus);
		
		programRequestDAO.updateProgramRequest(pr);
		
	}
	
	@Transactional
	public List<ProgramRequest> getWaitingMenteeRequests(int menteeId){
		
		String requestStatus = "Waiting";
		
		List<ProgramRequest> waitingRequests; 
		
		waitingRequests = programRequestDAO.getAllMenteeRequestsByStatus(menteeId, requestStatus);
			
		
		return waitingRequests;
		
	}
	
	@Transactional
	public ProgramRequest populateProgramRequest(int menteeId, int programId, String menteeComments, String status) {
		
		ProgramRequest programRequest = new ProgramRequest();
		
		Date date = new Date();
		
		programRequest.setMenteeId(menteeId);
		programRequest.setProgramId(programId);
		programRequest.setMenteeComments(menteeComments);
		programRequest.setRequestStatus(status);
		programRequest.setRequestedDate(date);
		
		return programRequest;
	}
	
	@Transactional
	public String requestValidation(int menteeId, int programId) {
		
		String status = "Valid";
		
		List<ProgramRequest> waitingRequests = programRequestDAO.getMenteeRequestsByProgramAndStatus(menteeId, programId, "Waiting");
		List<ProgramRequest> acceptedRequests = programRequestDAO.getMenteeRequestsByProgramAndStatus(menteeId, programId, "Accepted");
		List<ProgramRequest> rejectedRequests = programRequestDAO.getMenteeRequestsByProgramAndStatus(menteeId, programId, "Rejected");
		List<ProgramRequest> withdrawnRequests = programRequestDAO.getMenteeRequestsByProgramAndStatus(menteeId, programId, "Withdrawn");
		
		if(!waitingRequests.isEmpty()) {
			status = "Waiting";
		}
		else if (!acceptedRequests.isEmpty()) {
			status = "Accepted";			
		}
		else if (!rejectedRequests.isEmpty() || !withdrawnRequests.isEmpty()) {
			int noOfRequests = rejectedRequests.size() + withdrawnRequests.size();
			if(noOfRequests >= 3) {
				status = "Maximum";
			}
			else {
				status = "Valid";
			}
		}
		else {
			status = "Valid";
		}
		
		return status;
	}
	
	@Transactional
	public void updateMenteeRequestsToClosed(List<ProgramRequest> menteeRequests) {
		
		for(ProgramRequest menteeRequest: menteeRequests) {
			menteeRequest.setRequestStatus("Closed");
			programRequestDAO.updateProgramRequest(menteeRequest);
		}
		
	}
}
