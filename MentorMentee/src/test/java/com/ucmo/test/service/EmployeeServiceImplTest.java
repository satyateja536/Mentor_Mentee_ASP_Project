package com.ucmo.test.service;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.service.EmployeeService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"dispatcher-servlet-test.xml"})
public class EmployeeServiceImplTest {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	EmployeeService employeeService;
	
	
	@Test
	@Transactional
	public void testGetEmployee() {
		assertNotNull(employeeService.getEmployee(536));
	}
}
