package com.ucmo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dao.ProgramParticipantDAO;
import com.ucmo.dto.Program;
import com.ucmo.dto.ProgramParticipant;

@Service
@Transactional
public class ProgramParticipantServiceImpl implements ProgramParticipantService {
	
	@Autowired
	private ProgramParticipantDAO programParticipantDAO;
	
	public void setProgramParticipantDAO(ProgramParticipantDAO programParticipantDAO) {
		this.programParticipantDAO = programParticipantDAO;
	}

	@Transactional
	public void addProgramParticipant(ProgramParticipant programParticipant) {
		programParticipantDAO.addProgramParticipant(programParticipant);		
	}

	@Transactional
	public ProgramParticipant updateProgramParticipant(ProgramParticipant programParticipant) {
		 return programParticipantDAO.updateProgramParticipant(programParticipant);
		
	}

	@Transactional
	public List<ProgramParticipant> getAllProgramParticipants() {
		return programParticipantDAO.getAllProgramParticipants();
	}

	@Transactional
	public ProgramParticipant getProgramParticipant(int participantId) {
		return programParticipantDAO.getProgramParticipant(participantId);
	}

	@Transactional
	public void deleteProgramParticipant(int participantId) {
		programParticipantDAO.deleteProgramParticipant(participantId);		
	}
	
	public ProgramParticipant getParticipantByProgramAndStatus(int programId, int menteeId, String participationStatus) {
		return programParticipantDAO.getParticipantByProgramAndStatus(programId, menteeId, participationStatus);
	}
	
	@Transactional
	public List<ProgramParticipant> getAllParticipantsByProgramAndStatus(int programId, String participationStatus) {				
		return programParticipantDAO.getAllParticipantsByProgramAndStatus(programId, participationStatus);				
	}
	
	@Transactional
	public List<ProgramParticipant> getAllParticipantsByMenteeAndStatus(int menteeId, String participationStatus){
		return programParticipantDAO.getAllParticipantsByMenteeAndStatus(menteeId, participationStatus);
	}
	
	@Transactional
	public List<ProgramParticipant> getAllParticipantsByMentee(int menteeId){
		return programParticipantDAO.getAllParticipantsByMentee(menteeId);
	}
	
	@Transactional
	public int getNoOfActiveParticipantsByProgram(int programId) {
		
		int n = 0;
		
		String participationStatus = "Active";
		List<ProgramParticipant> participantList = programParticipantDAO.getAllParticipantsByProgramAndStatus(programId, participationStatus);
		if(!participantList.isEmpty()) {
			n = participantList.size();
		}
		
		return n;
	}
	
	@Transactional
	public int getNoOfInactiveParticipantsByProgram(int programId) {
		
		int n = 0;
		
		String participationStatus = "Inactive";
		List<ProgramParticipant> participantList = programParticipantDAO.getAllParticipantsByProgramAndStatus(programId, participationStatus);
		if(!participantList.isEmpty()) {
			n = participantList.size();
		}
		
		return n;
	}
	
	@Transactional
	public ProgramParticipant populateNewParticipant(Program program, int menteeId) {
		
		Date date = new Date();
		
		ProgramParticipant programParticipant = new ProgramParticipant();
		programParticipant.setProgramId(program.getProgramId());
		programParticipant.setMenteeId(menteeId);
		programParticipant.setCourseCompletionStatus("InProgress");
		programParticipant.setParticipationStatus("Active");
		programParticipant.setProgramDuration(program.getDuration());
		programParticipant.setStartDate(date);
		
		return programParticipant;
	}
	
	@Transactional
	public void updateParticipantsStatusToInactive(List<ProgramParticipant> participants) {
		
		String status = "Inactive";
		
		if(!participants.isEmpty()) {
			for(ProgramParticipant participant : participants) {
				participant.setParticipationStatus(status);
				programParticipantDAO.updateProgramParticipant(participant);
			}
		}
		
	}
	
	@Transactional
	public void updateParticipantsStatusToClosed(List<ProgramParticipant> participants) {
		
		String status = "Closed";
		
		if(!participants.isEmpty()) {
			for(ProgramParticipant participant : participants) {
				participant.setParticipationStatus(status);
				programParticipantDAO.updateProgramParticipant(participant);
			}
		}
		
	}

}
