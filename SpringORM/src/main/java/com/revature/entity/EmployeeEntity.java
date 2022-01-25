package com.revature.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "EMPLOYEE", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "EMAIL") })
public class EmployeeEntity {
	
	private static final long serialVersionUID = -1798070786993154676L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private int empId;
	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String email;
	@Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
	private String firstName;
	@Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
	private String lastName;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "allocationId")
	private Set<EmployeeAllocationEntity> empAllocations = new HashSet<EmployeeAllocationEntity>();
	public EmployeeEntity(int empId, String firstName, String lastName, String email) {
		super();
		this.empId = empId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setEmpAllocations(EmployeeAllocationEntity empAllocation) {
		this.empAllocations = empAllocations;
		
	}
	public Set<EmployeeAllocationEntity> getEmpAllocations() {
		// TODO Auto-generated method stub
		return empAllocations;
	}
	

	
}
