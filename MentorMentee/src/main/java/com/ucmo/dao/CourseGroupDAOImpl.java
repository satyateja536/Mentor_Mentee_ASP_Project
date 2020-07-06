package com.ucmo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucmo.dto.CourseGroup;

@Repository
public class CourseGroupDAOImpl implements CourseGroupDAO{
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addCourseGroup(CourseGroup courseGroup) {
		sessionFactory.getCurrentSession().saveOrUpdate(courseGroup);	
		
	}

	public CourseGroup updateCourseGroup(CourseGroup courseGroup) {
		sessionFactory.getCurrentSession().update(courseGroup);
        return courseGroup;		
		
	}

	@SuppressWarnings("unchecked")	
	public List<CourseGroup> getAllCourseGroups() {
		return sessionFactory.getCurrentSession().createQuery("from CourseGroup").list();
		
	}

	public CourseGroup getCourseGroup(int groupId) {
		return (CourseGroup) sessionFactory.getCurrentSession().get(CourseGroup.class, groupId);
		
	}


	public void deleteCourseGroup(int groupId) {
		CourseGroup courseGroup = (CourseGroup) sessionFactory.getCurrentSession().load(CourseGroup.class, groupId);
        if (null != courseGroup) {
            this.sessionFactory.getCurrentSession().delete(courseGroup);       
        }
	}

}
