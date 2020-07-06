package com.ucmo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DESIGNATION")
public class Designation {
	
	@Id
	@Column(name="DESIGNATION_ID")	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int designationId;
	
	@Column(name="DESIGNATION_NAME")
	private String designationName;

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	
	
	

}
