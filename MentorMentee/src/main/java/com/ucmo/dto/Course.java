package com.ucmo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {
	
	@Id
	@Column(name="COURSE_ID")	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int courseId;
	
	@Column(name="COURSE_NAME")
	private String courseName;
	
	@Column(name="COURSE_LEVEL")
	private String courseLevel;
	
	@Column(name="COURSE_GROUP")
	private String courseGroup;
	
	@Column(name="COURSE_STATUS")
	private String courseStatus;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}

	public String getCourseGroup() {
		return courseGroup;
	}

	public void setCourseGroup(String courseGroup) {
		this.courseGroup = courseGroup;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	
	

}
