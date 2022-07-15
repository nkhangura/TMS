package com.users;

public class employeeProfile {

	private String name;
	private String email;
	private int project;
	private int points;
	private int id;
	
	
	public employeeProfile(int id, String name, String email, int project, int points) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.project = project;
		this.points = points;
	}


	public employeeProfile() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getProject() {
		return project;
	}


	public void setProject(int project) {
		this.project = project;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "employeeProfile [name=" + name + ", email=" + email + ", project=" + project + ", points=" + points
				+ ", id=" + id + ", toString()=" + super.toString() + "]";
	}
	
	public void display() {
		System.out.println("****Welcom:"+ name +"!****");
		System.out.println("Employee ID: "+id);
		System.out.println("E-Mail: "+ email);
		System.out.println("Current Project: " + project);
		System.out.println("Points earned: "+ points);
	}


}
