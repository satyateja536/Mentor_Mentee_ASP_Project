package com.ucmo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dao.CourseDAO;
import com.ucmo.dto.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDAO;
	
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Transactional
	public void addCourse(Course course) {
		courseDAO.addCourse(course);		
	}

	@Transactional
	public Course updateCourse(Course course) {
		 return courseDAO.updateCourse(course);
		
	}

	@Transactional
	public List<Course> getAllCourses() {
		return courseDAO.getAllCourses();
	}

	@Transactional
	public Course getCourse(int courseId) {
		return courseDAO.getCourse(courseId);
	}

	@Transactional
	public void deleteCourse(int courseId) {
		courseDAO.deleteCourse(courseId);		
	}
	
	@Transactional
	public List<Course> getCourseByName(String courseName){
		return courseDAO.getCourseByName(courseName);
	}

	public int checkDupicateCourse(Course course) {
		
		int status = 1; 	// Course does not exist
		String courseName = course.getCourseName();
		String courseLevel = course.getCourseLevel();
		String courseGroup = course.getCourseGroup();
		
		List<Course> courseList = courseDAO.getCourseByName(courseName);
		
		if(!courseList.isEmpty()) {
			Course existingCourse = courseList.get(0);
			if(existingCourse.getCourseLevel().equalsIgnoreCase(courseLevel) &&
					existingCourse.getCourseGroup().equalsIgnoreCase(courseGroup)) {
				status = 0;		// Course exist 
			}			
		}	
		
		return status;
	}

	public int checkCourseExist(int courseId) {
		
		int status = 1;	// Course is valid
		
		Course course = courseDAO.getCourse(courseId);
		
		if(course == null || course.getCourseName() == null) {
			status = 0;	// Course is invalid
		}
				
		return status;
	}
	
	@Transactional
	public List<String> getDistinctCourseNamesByStatus(String status) {
		return courseDAO.getDistinctCourseNamesByStatus(status);
	}
	
	@Transactional
	public List<Course> getAciveCourseByName(String courseName){		
		
		List<Course> courseList = courseDAO.getCourseByName(courseName);
		List<Course> activeCourses = new ArrayList<Course>();
		
		for(Course course: courseList) {
			if(course.getCourseStatus().equalsIgnoreCase("Active")) {
				activeCourses.add(course);
			}
		}
		
		return activeCourses;
	}

}
