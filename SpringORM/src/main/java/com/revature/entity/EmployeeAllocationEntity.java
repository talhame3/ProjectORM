package com.revature.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "EMPLOYEE_ALLOCATION", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID") })
public class EmployeeAllocationEntity {
	
	private static final long serialVersionUID = -1798070786993154676L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private int allocationId;
	@Column(name = "ALLOCATION_NAME", unique = true, nullable = false, length = 100)
	private String allocationName;
	@ManyToOne
	@JoinColumn(name="employeeId")
	private EmployeeEntity empEntity;
	public EmployeeAllocationEntity(int allocationId, String allocationName, EmployeeEntity empEntity) {
		super();
		this.allocationId = allocationId;
		this.allocationName = allocationName;
		this.empEntity = empEntity;
	}
	public int getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}
	public String getAllocationName() {
		return allocationName;
	}
	public void setAllocationName(String allocationName) {
		this.allocationName = allocationName;
	}
	public EmployeeEntity getEmpEntity() {
		return empEntity;
	}
	public void setEmpEntity(EmployeeEntity empEntity) {
		this.empEntity = empEntity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
