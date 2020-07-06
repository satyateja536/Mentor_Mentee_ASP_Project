package com.ucmo.test.dao;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dao.DesignationDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"dispatcher-servlet-test.xml"})
public class DesignationDAOImplTest {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	DesignationDAO designationDAO;
	

	@Test
	public void testSetSessionFactory() {
		assertNotNull(sessionFactory);
	}

	@Test
	@Transactional
	public void testGetDesignation() {
		assertNotNull(designationDAO.getDesignation(101));
	}
}
