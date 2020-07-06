package com.ucmo.dao;

import java.util.List;

import com.ucmo.dto.CourseGroup;

public interface CourseGroupDAO {
	
	public void addCourseGroup(CourseGroup courseGroup);
	public CourseGroup updateCourseGroup(CourseGroup courseGroup);
	public List<CourseGroup> getAllCourseGroups();
	public CourseGroup getCourseGroup(int groupId);
	public void deleteCourseGroup(int groupId);

}
