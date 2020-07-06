package com.ucmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucmo.dto.User;

@Repository
public class UserDAOImpl implements UserDAO{	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}

	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
        return user;		
		
	}

	@SuppressWarnings("unchecked")	
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}

	/*
	 * public User getUser(String username) { return (User)
	 * sessionFactory.getCurrentSession().get(User.class, username);
	 * 
	 * }
	 */
	
	@SuppressWarnings("unchecked")
	public List<User> getUser(String username) {
		List<User> userList=new ArrayList<User>(); 
		      
		userList = sessionFactory.getCurrentSession()
		        			 .createQuery( "from User where username = :username" )
		        			 .setString( "username", username )
		        			 .list();		
		
		//userList =  sessionFactory.getCurrentSession().createQuery(getUserQuery).list();	
       
		return userList;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUserByEmployee(int employeeId) {
		List<User> userList=new ArrayList<User>(); 
		      
		userList = sessionFactory.getCurrentSession()
		        			 .createQuery( "from User where employeeId = :employeeId" )
		        			 .setInteger("employeeId", employeeId )
		        			 .list();		
		
		//userList =  sessionFactory.getCurrentSession().createQuery(getUserQuery).list();	
       
		return userList;
		
	}


	public void deleteUser(String username) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, username);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);       
        }
	}

}
