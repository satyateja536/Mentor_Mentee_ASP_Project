package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployee(int employeeId);
	public void deleteEmployee(int employeeId);
	public int validateEmployee(int employeeId, String employeeName);
	public List<Employee> getAllManagers();
	public List<Employee> getEmployeeByEmail(String email);
	public int checkEmployeeExistence(String email);
	public int validateEmployeeById(int employeeId);
	public String getManager(int employeeId);
}
