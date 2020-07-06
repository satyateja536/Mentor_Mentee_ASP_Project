package com.ucmo.dao;

import java.util.List;

import com.ucmo.dto.Designation;

public interface DesignationDAO {
	
	public void addDesignation(Designation designation);
	public Designation updateDesignation(Designation designation);
	public List<Designation> getAllDesignations();
	public Designation getDesignation(int designationId);
	public void deleteDesignation(int designationId);

}
