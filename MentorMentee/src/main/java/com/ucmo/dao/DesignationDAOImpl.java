package com.ucmo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucmo.dto.Designation;

@Repository
public class DesignationDAOImpl implements DesignationDAO{
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addDesignation(Designation designation) {
		sessionFactory.getCurrentSession().saveOrUpdate(designation);	
		
	}

	public Designation updateDesignation(Designation designation) {
		sessionFactory.getCurrentSession().update(designation);
        return designation;		
		
	}

	@SuppressWarnings("unchecked")	
	public List<Designation> getAllDesignations() {
		return sessionFactory.getCurrentSession().createQuery("from Designation").list();
		
	}

	public Designation getDesignation(int designationId) {
		return (Designation) sessionFactory.getCurrentSession().get(Designation.class, designationId);
		
	}


	public void deleteDesignation(int designationId) {
		Designation designation = (Designation) sessionFactory.getCurrentSession().load(Designation.class, designationId);
        if (null != designation) {
            this.sessionFactory.getCurrentSession().delete(designation);       
        }
	}

}
