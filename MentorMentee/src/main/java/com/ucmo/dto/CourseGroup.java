package com.ucmo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSE_GROUP")
public class CourseGroup {
	
	@Id
	@Column(name="GROUP_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int groupId;
	
	@Column(name="GROUP_NAME")
	private String groupName;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	
	

}
