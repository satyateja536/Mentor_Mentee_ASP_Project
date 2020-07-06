package com.ucmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucmo.dao.UserDAO;
import com.ucmo.dto.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	//private static final Logger logger = Logger
           // .getLogger(UserService.class);
	
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);		
	}

	@Transactional
	public User updateUser(User user) {
		 return userDAO.updateUser(user);
		
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Transactional
	public List<User> getUser(String username) {
		List<User> userList=null;
        
		 userList=userDAO.getUser(username);
       
		return userList;
	}

	@Transactional
	public void deleteUser(String username) {
		userDAO.deleteUser(username);		
	}
	
	@Transactional
	public int checkUserExistence(String username){		
		int status=1;  // user exists 
		
		List<User> user=null;
		user=userDAO.getUser(username);
		
		if(user.isEmpty() ){
		
			status=0; // user doesn't exist
		}
		
		
		return status;
	}
	
	@Transactional
	public int authenticateUser(String username,String password)  {
		int status=0; // Login Failed
		
		List<User> user=null;
		user=userDAO.getUser(username);
								
		if(user.get(0).getPassword().equals(password)){
			
				status=1; // Login Success
				
		}
		else
			    status=0; // Login failed
		
		
		return status;
	}
	
	@Transactional
	public int checkAdmin(String username) {
		
		int status = 0; // Logged in as user
		
		List<User> user;		
		user = userDAO.getUser(username);		
		
		if(user.get(0).getUserRole().equalsIgnoreCase("admin"))
		{
		status=1;	// Logged in as admin 
		}
		
			
		return status;
	}

	public String getUsernameByEmployee(int employeeId) {
		
		String username = null;   // No User for Employee
		
		List<User> user=null;
		user=userDAO.getUserByEmployee(employeeId);
		
		if(!user.isEmpty() ){
		
			username = user.get(0).getUsername();	// User exits for employee
		}			
		
		return username;
	}
	
	

}
