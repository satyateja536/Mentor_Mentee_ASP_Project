package com.ucmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dao.EmployeeDAO;
import com.ucmo.dto.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}


	@Transactional
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);		
	}

	@Transactional
	public Employee updateEmployee(Employee employee) {
		 return employeeDAO.updateEmployee(employee);
		
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Transactional
	public Employee getEmployee(int employeeId) {
		return employeeDAO.getEmployee(employeeId);
	}

	@Transactional
	public void deleteEmployee(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
		
	}

	@Transactional
	public int validateEmployee(int employeeId, String employeeName) {
		
		int status = 0;	// Employee is invalid
		
		Employee emp = employeeDAO.getEmployee(employeeId);
		
		if(emp.getEmployeeName().equals(employeeName)) {
			status = 1;	// Employee is valid
		}
				
		return status;
	}

	@Transactional
	public List<Employee> getAllManagers() {
		return employeeDAO.getAllManagers();
	}
	
	@Transactional
	public List<Employee> getEmployeeByEmail(String email) {
		return employeeDAO.getEmployeeByEmail(email);
	}


	public int checkEmployeeExistence(String email) {
		
		int status = 1;  // employee exists with given email
		
		List<Employee> employees=null;
		employees=employeeDAO.getEmployeeByEmail(email);
		
		if(employees.isEmpty() ){
		
			status=0; // employee with given email doesn't exist
		}
		
		return status;
	}
	
	@Transactional
	public int validateEmployeeById(int employeeId) {
		
		int status = 1;	// Employee is valid
		
		Employee emp = employeeDAO.getEmployee(employeeId);
		
		if(emp == null || emp.getEmployeeName() == null) {
			status = 0;	// Employee is invalid
		}
				
		return status;
	}
	
	public String getManager(int employeeId) {
		
		Employee emp = employeeDAO.getEmployee(employeeId);
		Employee manager = employeeDAO.getEmployee(emp.getReportsTo());
		
		return manager.getEmployeeName();
		
	}
	
	

}
