package com.ucmo.dao;

import java.util.List;

import com.ucmo.dto.User;

public interface UserDAO {
	
	public void addUser(User user);
	public User updateUser(User user);
	public List<User> getAllUsers();
	public List<User> getUser(String username);
	public List<User> getUserByEmployee(int employeeId);
	public void deleteUser(String username);

}
