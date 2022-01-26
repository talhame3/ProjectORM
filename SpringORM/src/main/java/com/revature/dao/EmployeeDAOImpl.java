package com.revature.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.entity.EmployeeAllocationEntity;
import com.revature.entity.EmployeeEntity;

public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory sessionFactory = null;
	
	@Override
	public void insertRecords() {
		// TODO Auto-generated method stub
	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Add new Employee object
	      EmployeeEntity emp = new EmployeeEntity(1, "Ash", "lee", "ash@gmail.com");
		
	   
	      EmployeeAllocationEntity empAllocation = new EmployeeAllocationEntity(1, "Project1", emp);
	      
	      emp.setEmpAllocations(empAllocation);
	      empAllocation = new EmployeeAllocationEntity(2,"project2",emp);
	      emp.setEmpAllocations(empAllocation);
	      
	      session.save(emp);
	      
	   // Add another Employee object
	      emp = new EmployeeEntity(2, "Goku", "Kakorote", "sayian@gmail.com");
	      
	      emp.setEmpAllocations(empAllocation);
	      
	      empAllocation = new EmployeeAllocationEntity(3, "Project3", emp);
	      emp.setEmpAllocations(empAllocation);
	      
	      session.save(emp);
	      
	   // After saving all employees, commit the transaction
	      session.getTransaction().commit();
	      session.close();
	}

	@Override
	public void listRecords() {
		// TODO Auto-generated method stub
		// Select Employee
		Session session = sessionFactory.openSession();
     List<EmployeeEntity> empList = session.createQuery("from EmployeeEntity").list();
     for(EmployeeEntity emp : empList) {
    	 System.out.println("==================Employee Details======================");
    	 System.out.println("Employee Name: " + emp.getFirstName() + " " + emp.getLastName());
    	 System.out.println("Email : " + emp.getEmail());
    	 
    	 System.out.println("+++++++++++++Employee Allocation Details+++++++++++++");
    	 Set<EmployeeAllocationEntity> empAllocationSet = emp.getEmpAllocations();
    	 Iterator<EmployeeAllocationEntity> it = empAllocationSet.iterator();
    	 while(it.hasNext()) {
    		 System.out.println("Allocation: " + it.next().getAllocationName());
    	 }
     }
     session.close();
	}
	
	@Override
	public void releaseResources() {
		sessionFactory.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
