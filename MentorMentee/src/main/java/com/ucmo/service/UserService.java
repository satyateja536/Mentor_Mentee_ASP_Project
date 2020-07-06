package com.ucmo.service;

import java.util.List;

import com.ucmo.dto.User;

public interface UserService {
	
	public void addUser(User user);
	public User updateUser(User user);
	public List<User> getAllUsers();
	public List<User> getUser(String username);
	public void deleteUser(String username);
	public int checkUserExistence(String username);
	public int authenticateUser(String username,String password);
	public int checkAdmin(String username);
	public String getUsernameByEmployee(int employeeId);

}
