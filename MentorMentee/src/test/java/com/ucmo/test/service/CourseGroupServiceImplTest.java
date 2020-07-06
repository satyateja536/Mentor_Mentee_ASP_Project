package com.ucmo.test.service;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.service.CourseGroupService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"dispatcher-servlet-test.xml"})
public class CourseGroupServiceImplTest {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CourseGroupService courseGroupService;
	

	@Test
	@Transactional
	public void testGetCourseGroup() {
		assertNotNull(courseGroupService.getCourseGroup(101));
	}
}
