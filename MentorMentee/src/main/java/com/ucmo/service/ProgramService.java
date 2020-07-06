package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.Program;

public interface ProgramService {
	
	public void addProgram(Program program);
	public Program updateProgram(Program program);
	public List<Program> getAllPrograms();	
	public Program getProgram(int programId);
	public void deleteProgram(int programId);
	public List<Program> getProgramsByMentor(int mentorId);
	public int checkDupicateProgram(Program program);	
	public int getNoOfAvailableSlots(int programId);
	public void increamentEnrolledNo(int programId);
	public void decreamentEnrolledNo(int programId);
	public List<String> getDistinctProgramNamesByStatus(String status);
	public List<Program> getProgramsByNamesAndStatus(String programName, String status);
	public List<Program> getProgramsWithSlots(String programName, String status);
	
	
	//public int checkProgramExist(int programId);

}
