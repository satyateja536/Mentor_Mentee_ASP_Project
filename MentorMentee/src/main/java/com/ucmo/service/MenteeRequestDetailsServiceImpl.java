package com.ucmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dto.Course;
import com.ucmo.dto.Employee;
import com.ucmo.dto.MenteeRequestDetails;
import com.ucmo.dto.Program;
import com.ucmo.dto.ProgramRequest;

@Service
@Transactional
public class MenteeRequestDetailsServiceImpl implements MenteeRequestDetailsService {	

	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private ProgramRequestService programRequestService;
	
	@Autowired
	private CourseService courseService;
	
	
	@Transactional
	public MenteeRequestDetails populateRequestDetails(int requestId) {
		
				
		ProgramRequest programRequest = programRequestService.getProgramRequest(requestId);
		Program program = programService.getProgram(programRequest.getProgramId());
		Course course = courseService.getCourse(program.getCourseId());
		Employee mentor = employeeService.getEmployee(program.getMentorId());
		
		MenteeRequestDetails menteeRequestDetails = new MenteeRequestDetails();
		
		menteeRequestDetails.setRequestId(requestId);
		menteeRequestDetails.setRequestComments(programRequest.getMenteeComments());
		menteeRequestDetails.setRequestStatus(programRequest.getRequestStatus());
		
		menteeRequestDetails.setProgramId(program.getProgramId());
		menteeRequestDetails.setProgramName(program.getProgramName());
		menteeRequestDetails.setCourseLevel(course.getCourseLevel());
		menteeRequestDetails.setCourseGroup(course.getCourseGroup());
		
		menteeRequestDetails.setMentorId(mentor.getEmployeeId());
		menteeRequestDetails.setMentorName(mentor.getEmployeeName());
		menteeRequestDetails.setMentorEmail(mentor.getEmail());
		
		
		return menteeRequestDetails;
	}
	
	
	
	
	
}
