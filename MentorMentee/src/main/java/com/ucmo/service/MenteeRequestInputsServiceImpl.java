package com.ucmo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dto.Employee;
import com.ucmo.dto.MenteeRequestInputs;
import com.ucmo.dto.Program;
import com.ucmo.dto.ProgramParticipant;
import com.ucmo.dto.ProgramRequest;

@Service
@Transactional
public class MenteeRequestInputsServiceImpl implements MenteeRequestInputsService {	

	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProgramService programService;
	

	@Transactional
	public List<MenteeRequestInputs> getMenteeRequestInputsByRequests(List<ProgramRequest> requestList) {
		
		List<MenteeRequestInputs> requestInputsList = new ArrayList<MenteeRequestInputs>();
		
		for(ProgramRequest request: requestList) {
			MenteeRequestInputs requestInput = new MenteeRequestInputs();
			
			Program program = programService.getProgram(request.getProgramId());
			Employee mentor = employeeService.getEmployee(program.getMentorId());
			
			requestInput.setRequestId(request.getRequestId());
			requestInput.setProgramId(program.getProgramId());
			requestInput.setProgramName(program.getProgramName());
			requestInput.setMentorName(mentor.getEmployeeName());
			requestInput.setRequestStatus(request.getRequestStatus());
			requestInputsList.add(requestInput);
		}
		
		return requestInputsList;
		
	}
	
	@Transactional
	public List<MenteeRequestInputs> getMenteeRequestInputsByPrograms(List<Program> programsList, int menteeId) {
		
		
		List<MenteeRequestInputs> menteeRequestInputsList = new ArrayList<MenteeRequestInputs>();
		
		for(Program program: programsList) {
			MenteeRequestInputs requestInput = new MenteeRequestInputs();
									
			Employee mentor = employeeService.getEmployee(program.getMentorId());	
			
			if(program.getMentorId() != menteeId) {
				
				requestInput.setProgramId(program.getProgramId());
				requestInput.setProgramName(program.getProgramName());
				requestInput.setMentorName(mentor.getEmployeeName());
				requestInput.setProgramDuration(program.getDuration());		
				
				menteeRequestInputsList.add(requestInput);
			}
			
			
		}
		
		return menteeRequestInputsList;
		
	}
	
	@Transactional
	public List<MenteeRequestInputs> getMenteeRequestInputsByParticipants(List<ProgramParticipant> participantsList) {
		
		List<MenteeRequestInputs> requestInputsList = new ArrayList<MenteeRequestInputs>();
		
		for(ProgramParticipant participant: participantsList) {
			MenteeRequestInputs requestInput = new MenteeRequestInputs();
			
			System.out.println("Participant Id: "+participant.getParticipantId());
			
			Program program = programService.getProgram(participant.getProgramId());
			Employee mentor = employeeService.getEmployee(program.getMentorId());
			
			requestInput.setParticipantSessionId(participant.getParticipantId());
			requestInput.setProgramId(program.getProgramId());
			requestInput.setProgramName(program.getProgramName());
			requestInput.setMentorName(mentor.getEmployeeName());
			
			requestInputsList.add(requestInput);
		}
		
		return requestInputsList;
		
	}
	
	
}
