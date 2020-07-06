package com.ucmo.dao;

import java.util.List;

import com.ucmo.dto.Course;

public interface CourseDAO {
	
	public void addCourse(Course course);
	public Course updateCourse(Course course);
	public List<Course> getAllCourses();
	public Course getCourse(int courseId);
	public void deleteCourse(int courseId);
	public List<Course> getCourseByName(String courseName);
	public List<String> getDistinctCourseNamesByStatus(String status);

}
