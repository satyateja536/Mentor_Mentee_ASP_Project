package com.ucmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucmo.dto.Program;

@Repository
public class ProgramDAOImpl implements ProgramDAO{
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addProgram(Program program) {
		sessionFactory.getCurrentSession().saveOrUpdate(program);	
		
	}

	public Program updateProgram(Program program) {
		sessionFactory.getCurrentSession().update(program);
        return program;		
		
	}

	@SuppressWarnings("unchecked")	
	public List<Program> getAllPrograms() {
		return sessionFactory.getCurrentSession().createQuery("from Program").list();
		
	}

	public Program getProgram(int programId) {
		return (Program) sessionFactory.getCurrentSession().get(Program.class, programId);
		
	}


	public void deleteProgram(int programId) {
		Program program = (Program) sessionFactory.getCurrentSession().load(Program.class, programId);
        if (null != program) {
            this.sessionFactory.getCurrentSession().delete(program);       
        }
	}	
	
	@SuppressWarnings("unchecked")
	public List<Program> getProgramsByMentor(int mentorId) {
		List<Program> programList=new ArrayList<Program>(); 
		      
		programList = sessionFactory.getCurrentSession()
		        			 .createQuery( "from Program where mentorId = :mentorId" )
		        			 .setInteger("mentorId", mentorId )
		        			 .list();				
       
		return programList;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Program> getProgramByMentorAndCourse(int mentorId, int courseId) {
		List<Program> programList=new ArrayList<Program>(); 
		      
		programList = sessionFactory.getCurrentSession()
		        			 .createQuery( "from Program where mentorId = :mentorId"
		        			 		+ " and courseId = :courseId" )
		        			 .setInteger("mentorId", mentorId )
		        			 .setInteger("courseId", courseId )
		        			 .list();				
       
		return programList;
		
	}
	
	@SuppressWarnings("unchecked")	
	public List<String> getDistinctProgramNamesByStatus(String status) {
		return sessionFactory.getCurrentSession()
				             .createQuery("select distinct programName from Program where status = :status")
				             .setString("status", status)
				             .list();
		
	}
	
	@SuppressWarnings("unchecked")	
	public List<Program> getProgramsByNamesAndStatus(String programName, String status) {
		return sessionFactory.getCurrentSession()
				             .createQuery("from Program where programName = :programName and status = :status")
				             .setString("programName", programName)
				             .setString("status", status)
				             .list();
		
	}
	
		
}
