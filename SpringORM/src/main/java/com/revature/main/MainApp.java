package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class MainApp {
	
	public static void main(String[] args) {
		
		   ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config.xml");
		
		   EmployeeDAO employeeDao = (EmployeeDAOImpl) appContext.getBean("employeeDao");
		   employeeDao.insertRecords();
		   employeeDao.listRecords();
		   employeeDao.releaseResources();
	}

}
