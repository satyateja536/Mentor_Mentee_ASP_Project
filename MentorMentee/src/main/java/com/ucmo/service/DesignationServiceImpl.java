package com.ucmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dao.DesignationDAO;
import com.ucmo.dto.Designation;

@Service
@Transactional
public class DesignationServiceImpl implements DesignationService {
	
	@Autowired
	private DesignationDAO designationDAO;
	
	public void setDesignationDAO(DesignationDAO designationDAO) {
		this.designationDAO = designationDAO;
	}

	@Transactional
	public void addDesignation(Designation designation) {
		designationDAO.addDesignation(designation);		
	}

	@Transactional
	public Designation updateDesignation(Designation designation) {
		 return designationDAO.updateDesignation(designation);
		
	}

	@Transactional
	public List<Designation> getAllDesignations() {
		return designationDAO.getAllDesignations();
	}

	@Transactional
	public Designation getDesignation(int designationId) {
		return designationDAO.getDesignation(designationId);
	}

	@Transactional
	public void deleteDesignation(int designationId) {
		designationDAO.deleteDesignation(designationId);		
	}

}
