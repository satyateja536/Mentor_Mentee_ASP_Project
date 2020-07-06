package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.Designation;

public interface DesignationService {
	
	public void addDesignation(Designation designation);
	public Designation updateDesignation(Designation designation);
	public List<Designation> getAllDesignations();
	public Designation getDesignation(int designationId);
	public void deleteDesignation(int designationId);

}
