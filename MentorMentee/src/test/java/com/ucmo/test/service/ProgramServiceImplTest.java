package com.ucmo.test.service;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.service.ProgramService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"dispatcher-servlet-test.xml"})
public class ProgramServiceImplTest {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ProgramService programService;	


	@Test
	@Transactional
	public void testGetAllPrograms() {
		assertNotNull(programService.getAllPrograms());
	}
}
