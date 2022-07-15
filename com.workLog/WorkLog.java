package com.workLog;

public class WorkLog {
	private int id;
	private String description;
	private String creationDate;
	private int emp_id;
	
	
	public WorkLog() {
		super();
	
	}

	public WorkLog(int id, String description, String creationDate, int emp_id) {
		super();
		this.id = id;
		this.description = description;
		this.creationDate = creationDate;
		this.emp_id = emp_id;
	}

	public int getId() {
		return id;
	}

/*	public void setId(int id) {
		this.id = id;
	}
*/
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

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	@Override
	public String toString() {
		return "WorkLog [id=" + id + ", description=" + description + ", creationDate=" + creationDate + ", emp_id="
				+ emp_id + "]";
	}
	
}

