# ProjectORM

Required Software
JDK 
Maven 
Spring tool Suite

In this project, I have integrated Spring with Hibernate.
In this project HSQLDB jar has been used. So no real database is required to run the stand alone application.

spring-config.xml:Data source and session factory is configured in this file.

EmployeeEntity and EmployeeAllocationEntity:These two hibernate entity classes are having one to many relationsship. 
In EmployeeEntity class @OneToMany and in EmployeeAllocationEntity class @ManyToOne annotations are used to established the relationship in hibernate
  
EmployeeDAO and EmployeeDAOImpl:EmployeeDAOImpl implements insertRecords() and listRecords() methods of EmployeeDAO interface.

MainApp:This class contains the main method and calls DAO services
