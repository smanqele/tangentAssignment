package com.sihle.tangent.bean;

public class Task {
	
	private int id = 0;
	private String title = "";
	private String due_date = "";
	private double estimated_hours = 0.00;
	private int project = 0;
	private ProjectData project_data = null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public double getEstimated_hours() {
		return estimated_hours;
	}
	public void setEstimated_hours(double estimated_hours) {
		this.estimated_hours = estimated_hours;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	public ProjectData getProject_data() {
		return project_data;
	}
	public void setProject_data(ProjectData project_data) {
		this.project_data = project_data;
	}
	
	


	
	

}
