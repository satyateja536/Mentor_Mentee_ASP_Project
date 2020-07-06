package com.ucmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dto.Course;
import com.ucmo.dto.Employee;
import com.ucmo.dto.MenteeProgramSession;
import com.ucmo.dto.Program;
import com.ucmo.dto.ProgramParticipant;

@Service
@Transactional
public class MenteeProgramSessionServiceImpl implements MenteeProgramSessionService {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private ProgramParticipantService programParticipantService;
	

	@Transactional
	public MenteeProgramSession getMenteeProgramSession(int participantId) {
		
		ProgramParticipant participant = programParticipantService.getProgramParticipant(participantId);
				
		Program program = programService.getProgram(participant.getProgramId());		
		
		Employee mentor = employeeService.getEmployee(program.getMentorId());		
		
		Course course = courseService.getCourse(program.getCourseId());				
		
		MenteeProgramSession menteeProgramSession = new MenteeProgramSession();
		
		menteeProgramSession.setMentor(mentor);
		menteeProgramSession.setProgram(program);
		menteeProgramSession.setCourse(course);
		menteeProgramSession.setParticipant(participant);		
		menteeProgramSession.setParticipantId(participant.getParticipantId());		
		menteeProgramSession.setMentorNotes(participant.getMentorNotes());
		menteeProgramSession.setMenteeNotes(participant.getMenteeNotes());
		menteeProgramSession.setSessionStatus(participant.getParticipationStatus());
		
		return menteeProgramSession;
	}
	
	
}
