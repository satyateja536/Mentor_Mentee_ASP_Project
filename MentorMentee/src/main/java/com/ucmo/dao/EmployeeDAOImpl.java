package com.ucmo.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucmo.dto.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);	
		
	}

	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
        return employee;		
		
	}

	@SuppressWarnings("unchecked")	
	public List<Employee> getAllEmployees() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
		
	}

	public Employee getEmployee(int employeeId) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, employeeId);
		
	}


	public void deleteEmployee(int employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);       
        }
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllManagers() {
		return sessionFactory.getCurrentSession().createQuery("from Employee where isManager = 'yes' ").list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeByEmail(String email) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList = sessionFactory.getCurrentSession()
   			 .createQuery( "from Employee where email = :email" )
   			 .setString( "email", email )
   			 .list();
		
		return employeeList;
	}
	
	
	
	

}
