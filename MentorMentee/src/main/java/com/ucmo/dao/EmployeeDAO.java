package com.ucmo.dao;

import java.util.List;

import com.ucmo.dto.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployee(int employeeId);
	public void deleteEmployee(int employeeId);
	public List<Employee> getAllManagers();
	public List<Employee> getEmployeeByEmail(String email);

}
