package com.ucmo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucmo.dto.ProgramRequest;

@Repository
public class ProgramRequestDAOImpl implements ProgramRequestDAO{
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addProgramRequest(ProgramRequest programRequest) {
		sessionFactory.getCurrentSession().saveOrUpdate(programRequest);	
		
	}

	public ProgramRequest updateProgramRequest(ProgramRequest programRequest) {
		sessionFactory.getCurrentSession().update(programRequest);
        return programRequest;		
		
	}

	@SuppressWarnings("unchecked")	
	public List<ProgramRequest> getAllProgramRequests() {
		return sessionFactory.getCurrentSession().createQuery("from ProgramRequest").list();
		
	}

	public ProgramRequest getProgramRequest(int requestId) {
		return (ProgramRequest) sessionFactory.getCurrentSession().get(ProgramRequest.class, requestId);
		
	}


	public void deleteProgramRequest(int requestId) {
		ProgramRequest programRequest = (ProgramRequest) sessionFactory.getCurrentSession().load(ProgramRequest.class, requestId);
        if (null != programRequest) {
            this.sessionFactory.getCurrentSession().delete(programRequest);       
        }
	}
	
	@SuppressWarnings("unchecked")	
	public List<ProgramRequest> getAllRequestsByProgram(int programId, String requestStatus) {
		
		return sessionFactory.getCurrentSession().createQuery("from ProgramRequest where programId = :programId"
				+ " and requestStatus = :requestStatus ")
				.setInteger("programId", programId)
				.setString("requestStatus", requestStatus)
				.list();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ProgramRequest> getAllMenteeRequestsByStatus(int menteeId, String requestStatus){
		
		return sessionFactory.getCurrentSession().createQuery("from ProgramRequest where menteeId = :menteeId"
				+ " and requestStatus = :requestStatus ")
				.setInteger("menteeId", menteeId)
				.setString("requestStatus", requestStatus)
				.list();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ProgramRequest> getMenteeRequestsByProgramAndStatus(int menteeId, int programId, String requestStatus){
		
		return sessionFactory.getCurrentSession().createQuery("from ProgramRequest where menteeId = :menteeId"
				+ " and programId = :programId and requestStatus = :requestStatus ")
				.setInteger("menteeId", menteeId)
				.setInteger("programId", programId)
				.setString("requestStatus", requestStatus)
				.list();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ProgramRequest> getNonWaitingMenteeRequests(int menteeId){
		
		String requestStatus = "Waiting";
		
		return sessionFactory.getCurrentSession().createQuery("from ProgramRequest where menteeId = :menteeId"
				+ " and requestStatus != :requestStatus ")
				.setInteger("menteeId", menteeId)
				.setString("requestStatus", requestStatus)
				.list();
		
	}

}
