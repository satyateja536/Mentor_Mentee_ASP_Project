package com.ucmo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dto.ProgramParticipant;
import com.ucmo.dto.RequestDetails;

@Service
@Transactional
public class RequestDetailsServiceImpl implements RequestDetailsService {	
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private ProgramRequestService programRequestService;

	

	@Transactional
	public RequestDetails populateRequestDetails(int requestId, int menteeId, int programId) {
		
		
		int courseId = programService.getProgram(programId).getCourseId();
		String menteeName = employeeService.getEmployee(menteeId).getEmployeeName();
		String menteeDesignation = employeeService.getEmployee(menteeId).getEmployeeDesignation();
		String manager = employeeService.getManager(menteeId);
		String programName = programService.getProgram(programId).getProgramName();
		String courseLevel = courseService.getCourse(courseId).getCourseLevel();
		String courseGroup = courseService.getCourse(courseId).getCourseGroup();
		String menteeComments = programRequestService.getProgramRequest(requestId).getMenteeComments();
		int noOfAvailableSlots = programService.getNoOfAvailableSlots(programId);
		
		
		RequestDetails requestDetails = new RequestDetails();	
		requestDetails.setRequestId(requestId);
		requestDetails.setMenteeId(menteeId);
		requestDetails.setMenteeName(menteeName);
		requestDetails.setMenteeDesignation(menteeDesignation);
		requestDetails.setManager(manager);
		requestDetails.setProgramId(programId);
		requestDetails.setProgramName(programName);
		requestDetails.setCourseLevel(courseLevel);
		requestDetails.setCourseGroup(courseGroup);
		requestDetails.setMenteeComments(menteeComments);
		requestDetails.setNoOfAvailableSlots(noOfAvailableSlots);		
		
		return requestDetails;
		
	}


	@Transactional
	public List<RequestDetails> getReqDetailsFromParticipants(List<ProgramParticipant> programParticipantList,
			int programId, String sessionStatus) {
		
		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();
		
		for(ProgramParticipant programParticipant : programParticipantList) {
			RequestDetails requestDetails = new RequestDetails();
			int menteeId = programParticipant.getMenteeId();
			String menteeName = employeeService.getEmployee(menteeId).getEmployeeName();
			String manager = employeeService.getManager(menteeId);
			
			requestDetails.setProgramId(programId);
			requestDetails.setMenteeId(menteeId);
			requestDetails.setMenteeName(menteeName);
			requestDetails.setManager(manager);
			requestDetails.setRequestStatus(sessionStatus);
			requestDetailsList.add(requestDetails);
		}
		
		return requestDetailsList;
	}	
	
	

	
	
}
