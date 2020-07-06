package com.ucmo.dao;

import java.util.List;

import com.ucmo.dto.Program;

public interface ProgramDAO {
	
	public void addProgram(Program program);
	public Program updateProgram(Program program);
	public List<Program> getAllPrograms();
	public Program getProgram(int programId);
	public void deleteProgram(int programId);
	public List<Program> getProgramsByMentor(int mentorId);
	public List<Program> getProgramByMentorAndCourse(int mentorId, int courseId);	
	public List<String> getDistinctProgramNamesByStatus(String status);
	public List<Program> getProgramsByNamesAndStatus(String programName, String status);
	

}
