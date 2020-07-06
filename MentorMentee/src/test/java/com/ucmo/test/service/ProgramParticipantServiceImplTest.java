package com.ucmo.test.service;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.service.ProgramParticipantService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"dispatcher-servlet-test.xml"})
public class ProgramParticipantServiceImplTest {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ProgramParticipantService programParticipantService;	


	@Test
	@Transactional
	public void testGetAllProgramParticipants() {
		assertNotNull(programParticipantService.getAllProgramParticipants());
	}
}
