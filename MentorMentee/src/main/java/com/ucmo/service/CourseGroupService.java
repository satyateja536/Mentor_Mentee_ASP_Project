package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.CourseGroup;

public interface CourseGroupService {
	
	public void addCourseGroup(CourseGroup courseGroup);
	public CourseGroup updateCourseGroup(CourseGroup courseGroup);
	public List<CourseGroup> getAllCourseGroups();
	public CourseGroup getCourseGroup(int groupId);
	public void deleteCourseGroup(int groupId);

}
