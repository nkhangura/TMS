package com.springboot.jira.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="worklog")
public class WorkLog {
	
	/* Attributes */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String creationDate;
	
	@OneToOne
	private Employee employee;

	/* Constructors */
	public WorkLog() {
		super();
		
	}

	public WorkLog(Long id, String description, String creationDate, Employee employee) {
		super();
		this.id = id;
		this.description = description;
		this.creationDate = creationDate;
		this.employee = employee;
	}

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/* toString */
	@Override
	public String toString() {
		return "WorkLog [id=" + id + ", description=" + description + ", creationDate=" + creationDate + ", employee="
				+ employee + "]";
	}
	
	
	
}

