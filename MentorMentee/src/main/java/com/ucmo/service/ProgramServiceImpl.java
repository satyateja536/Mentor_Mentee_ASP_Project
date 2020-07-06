package com.ucmo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dao.ProgramDAO;
import com.ucmo.dto.Program;

@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {
	
	@Autowired
	private ProgramDAO programDAO;
	
	public void setProgramDAO(ProgramDAO programDAO) {
		this.programDAO = programDAO;
	}

	@Transactional
	public void addProgram(Program program) {
		programDAO.addProgram(program);		
	}

	@Transactional
	public Program updateProgram(Program program) {
		 return programDAO.updateProgram(program);
		
	}

	@Transactional
	public List<Program> getAllPrograms() {
		return programDAO.getAllPrograms();
	}

	@Transactional
	public Program getProgram(int programId) {
		return programDAO.getProgram(programId);
	}

	@Transactional
	public void deleteProgram(int programId) {
		programDAO.deleteProgram(programId);		
	}
	
	@Transactional
	public List<Program> getProgramsByMentor(int mentorId){
		return programDAO.getProgramsByMentor(mentorId);
	}	
	
	@Transactional
	public List<String> getDistinctProgramNamesByStatus(String status){
		return programDAO.getDistinctProgramNamesByStatus(status);
	}
	
	@Transactional
	public List<Program> getProgramsByNamesAndStatus(String programName, String status){
		return programDAO.getProgramsByNamesAndStatus(programName, status);
	}	
	

	@Transactional
	public int checkDupicateProgram(Program program) {
		
		int status = 0; 	// Program exists		
		
		int mentorId = program.getMentorId();
		int courseId = program.getCourseId();
		
		List<Program> programList = programDAO.getProgramByMentorAndCourse(mentorId, courseId);
		  
		if(programList.isEmpty()) {
			status = 1; 	// Program does not exist
		}		 	
		
		return status;
	}

	/*
	 * public int checkProgramExist(int programId) {
	 * 
	 * int status = 1; // Program is valid
	 * 
	 * Program program = programDAO.getProgram(programId);
	 * 
	 * if(program == null || program.getProgramName() == null) { status = 0; //
	 * Program is invalid }
	 * 
	 * return status; }*/
	
	public int getNoOfAvailableSlots(int programId) {
		
		int number = 0;
		
		Program program = programDAO.getProgram(programId);
		
		int noOfenrolled = program.getEnrolledNoOfMentees();
		int noOfAllowed = program.getAllowedNoOfMentees();
		
		int difference = noOfAllowed - noOfenrolled;
		
		if(difference > 0) {
			number = difference;
		}
		
		return number;
	}
	
	public void increamentEnrolledNo(int programId) {
		
		Program program = programDAO.getProgram(programId);
		
		int n = program.getEnrolledNoOfMentees();
		
		program.setEnrolledNoOfMentees(n+1);
		
		programDAO.updateProgram(program);		
		
	}
	
	public void decreamentEnrolledNo(int programId) {
		
		Program program = programDAO.getProgram(programId);
		
		int n = program.getEnrolledNoOfMentees();
		
		program.setEnrolledNoOfMentees(n-1);		
		
		programDAO.updateProgram(program);		
		
	}
	
	public List<Program> getProgramsWithSlots(String programName, String status){
		
		List<Program> programsList = programDAO.getProgramsByNamesAndStatus(programName, status);
		
		List<Program> programsWithSlots = new ArrayList<Program>();
		
		for(Program program: programsList) {
			
			int noOfenrolled = program.getEnrolledNoOfMentees();
			int noOfAllowed = program.getAllowedNoOfMentees();
			int difference = noOfAllowed - noOfenrolled;
			
			if(difference > 0) {
				programsWithSlots.add(program);
			}
			
		}
		
		return programsWithSlots;
		
	}

}
