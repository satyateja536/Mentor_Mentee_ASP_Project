package com.ucmo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {	
	
	@Id
	@Column(name="USERNAME")	
	private String username;
	
	@Column(name="PASSWORD")	
	private String password;
	
	@Column(name="MENTOR_STATUS")	
	private String mentorStatus;
	
	@Column(name="MENTEE_STATUS")	
	private String menteeStatus;
	
	@Column(name="EMPLOYEE_ID")	
	private int employeeId;
	
	@Column(name="USER_ROLE")
	private String userRole;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMentorStatus() {
		return mentorStatus;
	}

	public void setMentorStatus(String mentorStatus) {
		this.mentorStatus = mentorStatus;
	}

	public String getMenteeStatus() {
		return menteeStatus;
	}

	public void setMenteeStatus(String menteeStatus) {
		this.menteeStatus = menteeStatus;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}	
	

}
