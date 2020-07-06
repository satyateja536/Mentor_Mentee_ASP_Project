package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.Course;

public interface CourseService {
	
	public void addCourse(Course course);
	public Course updateCourse(Course course);
	public List<Course> getAllCourses();
	public Course getCourse(int courseId);
	public void deleteCourse(int courseId);
	public List<Course> getCourseByName(String courseName);
	public int checkDupicateCourse(Course course);
	public int checkCourseExist(int courseId);
	public List<String> getDistinctCourseNamesByStatus(String status);
	public List<Course> getAciveCourseByName(String courseName);

}
