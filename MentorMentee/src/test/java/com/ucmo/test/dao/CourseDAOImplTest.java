package com.ucmo.test.dao;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dao.CourseDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"dispatcher-servlet-test.xml"})
public class CourseDAOImplTest {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CourseDAO courseDAO;
	

	@Test
	public void testSetSessionFactory() {
		assertNotNull(sessionFactory);
	}

	@Test
	@Transactional
	public void testGetCourse() {
		assertNotNull(courseDAO.getCourse(201));
	}
}
