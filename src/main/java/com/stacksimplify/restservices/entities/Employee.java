package com.stacksimplify.restservices.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.stacksimplify.restservices.entities.views.EmployeeViews;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue 
	@JsonView({EmployeeViews.NormalView.class, EmployeeViews.ManagerView.class, EmployeeViews.HRView.class})
	private Long empid;
	
	@NotEmpty(message="Name is a Mandatory field. Please provide a Name.")
	@Size(min=2, message="Name should have at least 2 characters.")
	@JsonView({EmployeeViews.NormalView.class, EmployeeViews.ManagerView.class, EmployeeViews.HRView.class})
	private String name;
	
	@Size(min=2, message="Department should have at least 2 characters.")
	@JsonView({EmployeeViews.NormalView.class, EmployeeViews.ManagerView.class, EmployeeViews.HRView.class})
	private String department;
	
	@JsonView({EmployeeViews.ManagerView.class})
	private LocalDateTime loginTime;
	@JsonView({EmployeeViews.ManagerView.class})
    private LocalDateTime logoutTime;
    
    @Min(1000)
    @JsonView({EmployeeViews.HRView.class})
    private Long salary;
    
    @JsonView({EmployeeViews.HRView.class})
    private LocalDate lastPromotionDate;
       

	public Employee() {
		super();
	}

	public Employee(Long empid,
			@NotEmpty(message = "Name is a Mandatory field. Please provide a Name.") @Size(min = 2, message = "Name should have at least 2 characters.") String name,
			@Size(min = 2, message = "Department should have at least 2 characters.") String department,
			LocalDateTime loginTime, LocalDateTime logoutTime, @Min(1000) Long salary, LocalDate lastPromotionDate) {
		super();
		this.empid = empid;
		this.name = name;
		this.department = department;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.salary = salary;
		this.lastPromotionDate = lastPromotionDate;
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDateTime getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}

	public LocalDateTime getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(LocalDateTime logoutTime) {
		this.logoutTime = logoutTime;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public LocalDate getLastPromotionDate() {
		return lastPromotionDate;
	}

	public void setLastPromotionDate(LocalDate lastPromotionDate) {
		this.lastPromotionDate = lastPromotionDate;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", department=" + department + ", loginTime=" + loginTime
				+ ", logoutTime=" + logoutTime + ", salary=" + salary + ", lastPromotionDate=" + lastPromotionDate
				+ "]";
	}
}
