package com.ucmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dao.CourseGroupDAO;
import com.ucmo.dto.CourseGroup;

@Service
@Transactional
public class CourseGroupServiceImpl implements CourseGroupService {
	
	@Autowired
	private CourseGroupDAO courseGroupDAO;
	
	public void setCourseGroupDAO(CourseGroupDAO courseGroupDAO) {
		this.courseGroupDAO = courseGroupDAO;
	}

	@Transactional
	public void addCourseGroup(CourseGroup courseGroup) {
		courseGroupDAO.addCourseGroup(courseGroup);		
	}

	@Transactional
	public CourseGroup updateCourseGroup(CourseGroup courseGroup) {
		 return courseGroupDAO.updateCourseGroup(courseGroup);
		
	}

	@Transactional
	public List<CourseGroup> getAllCourseGroups() {
		return courseGroupDAO.getAllCourseGroups();
	}

	@Transactional
	public CourseGroup getCourseGroup(int groupId) {
		return courseGroupDAO.getCourseGroup(groupId);
	}

	@Transactional
	public void deleteCourseGroup(int groupId) {
		courseGroupDAO.deleteCourseGroup(groupId);		
	}

}
