package com.mayank.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@I
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	
	@NotBlank
    private String username;

    @NotBlank
    private String designation;
    
    @NotBlank
    private String salary;
    
    @NotBlank
    private String experience;
    
    @NotBlank
    private String department;
    
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    public void setUsername(String username)
    {
    	this.username=username;
    }
    public void setDesignation(String designation)
    {
    	this.designation=designation;
    }
    public void setSalary(String salary)
    {
    	this.salary=salary;
    }
    public void setExperience(String experience)
    {
    	this.experience=experience;
    }
    public void setDepartment(String department)
    {
    	this.department=department;
    }
    public String getUsername()
    {
    	return username;
 	 }
    public String getDesignation()
    {
    	return designation;
 	 }
    public String getSalary()
    {
    	return salary;
 	 }
    public String getExperience()
    {
    	return experience;
 	 }
    public String getDepartment()
    {
    	return department;
 	 }
    
    
    
    
    
	
	
}
