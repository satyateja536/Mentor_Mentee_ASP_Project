package com.ucmo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucmo.dto.ProgramParticipant;

@Repository
public class ProgramParticipantDAOImpl implements ProgramParticipantDAO{
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addProgramParticipant(ProgramParticipant programParticipant) {
		sessionFactory.getCurrentSession().saveOrUpdate(programParticipant);	
		
	}

	public ProgramParticipant updateProgramParticipant(ProgramParticipant programParticipant) {
		sessionFactory.getCurrentSession().update(programParticipant);
        return programParticipant;		
		
	}

	@SuppressWarnings("unchecked")	
	public List<ProgramParticipant> getAllProgramParticipants() {
		return sessionFactory.getCurrentSession().createQuery("from ProgramParticipant").list();
		
	}

	public ProgramParticipant getProgramParticipant(int participantId) {
		return (ProgramParticipant) sessionFactory.getCurrentSession().get(ProgramParticipant.class, participantId);
		
	}

	public void deleteProgramParticipant(int participantId) {
		ProgramParticipant programParticipant = (ProgramParticipant) sessionFactory.getCurrentSession().load(ProgramParticipant.class, participantId);
        if (null != programParticipant) {
            this.sessionFactory.getCurrentSession().delete(programParticipant);       
        }
	}
	
	@SuppressWarnings("unchecked")	
	public List<ProgramParticipant> getAllParticipantsByProgramAndStatus(int programId, String participationStatus) {
		
		return sessionFactory.getCurrentSession().createQuery("from ProgramParticipant where "
				+ " programId = :programId and participationStatus = :participationStatus ")
				.setInteger("programId", programId)
				.setString("participationStatus", participationStatus)
				.list();
		
	}
			
	public ProgramParticipant getParticipantByProgramAndStatus(int programId, int menteeId, String participationStatus) {
		
		return (ProgramParticipant) sessionFactory.getCurrentSession().createQuery("from ProgramParticipant where "
				+ " programId = :programId and menteeId = :menteeId"
				+ " and participationStatus = :participationStatus ")
				.setInteger("programId", programId)
				.setInteger("menteeId", menteeId)
				.setString("participationStatus", participationStatus)
				.list().get(0);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ProgramParticipant> getAllParticipantsByMenteeAndStatus(int menteeId, String participationStatus){
		
		return sessionFactory.getCurrentSession().createQuery("from ProgramParticipant where "
				+ " menteeId = :menteeId and participationStatus = :participationStatus ")
				.setInteger("menteeId", menteeId)
				.setString("participationStatus", participationStatus)
				.list();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ProgramParticipant> getAllParticipantsByMentee(int menteeId){
		
		return sessionFactory.getCurrentSession().createQuery("from ProgramParticipant where "
				+ " menteeId = :menteeId ")
				.setInteger("menteeId", menteeId)				
				.list();
		
	}
	

}
