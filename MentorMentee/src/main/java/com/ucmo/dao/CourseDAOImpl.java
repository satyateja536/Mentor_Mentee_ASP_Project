package com.ucmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucmo.dto.Course;

@Repository
public class CourseDAOImpl implements CourseDAO{
	
		
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addCourse(Course course) {
		sessionFactory.getCurrentSession().saveOrUpdate(course);	
		
	}

	public Course updateCourse(Course course) {
		sessionFactory.getCurrentSession().update(course);
        return course;		
		
	}

	@SuppressWarnings("unchecked")	
	public List<Course> getAllCourses() {
		return sessionFactory.getCurrentSession().createQuery("from Course").list();
		
	}

	public Course getCourse(int courseId) {
		return (Course) sessionFactory.getCurrentSession().get(Course.class, courseId);
		
	}


	public void deleteCourse(int courseId) {
		Course course = (Course) sessionFactory.getCurrentSession().load(Course.class, courseId);
        if (null != course) {
            this.sessionFactory.getCurrentSession().delete(course);       
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> getCourseByName(String courseName) {
		List<Course> courseList=new ArrayList<Course>(); 
		      
		courseList = sessionFactory.getCurrentSession()
		        			 .createQuery( "from Course where courseName = :courseName" )
		        			 .setString( "courseName", courseName )
		        			 .list();		
		
		//userList =  sessionFactory.getCurrentSession().createQuery(getUserQuery).list();	
       
		return courseList;
		
	}
	
	@SuppressWarnings("unchecked")	
	public List<String> getDistinctCourseNamesByStatus(String status) {
		return sessionFactory.getCurrentSession()
				             .createQuery("select distinct courseName from Course where courseStatus = :courseStatus")
				             .setString("courseStatus", status)
				             .list();
		
	}

}
