package com.ucmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dto.Course;
import com.ucmo.dto.Employee;
import com.ucmo.dto.Program;
import com.ucmo.dto.ProgramParticipant;
import com.ucmo.dto.ProgramSession;

@Service
@Transactional
public class ProgramSessionServiceImpl implements ProgramSessionService {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private ProgramParticipantService programParticipantService;


	@Transactional
	public ProgramSession getProgramSession(int menteeId, int programId, String sessionStatus) {
		
		Employee mentee = employeeService.getEmployee(menteeId);
		
		Program program = programService.getProgram(programId);
		
		Course course = courseService.getCourse(program.getCourseId());
		
		ProgramParticipant participant = programParticipantService.getParticipantByProgramAndStatus(programId, menteeId, sessionStatus);
		
		String manager = employeeService.getEmployee(mentee.getReportsTo()).getEmployeeName();
		
		ProgramSession programSession = new ProgramSession();
		
		programSession.setMentee(mentee);
		programSession.setProgram(program);
		programSession.setCourse(course);
		programSession.setParticipant(participant);
		programSession.setManager(manager);
		programSession.setParticipantId(participant.getParticipantId());
		programSession.setCourseCompletionStatus(participant.getCourseCompletionStatus());
		programSession.setMentorNotes(participant.getMentorNotes());
		programSession.setMenteeNotes(participant.getMenteeNotes());
		programSession.setSessionStatus(sessionStatus);
		
		return programSession;
	}	
	
}
