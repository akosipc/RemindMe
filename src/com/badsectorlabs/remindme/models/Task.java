package com.badsectorlabs.remindme.models;

import java.util.Date;

public class Task {
	private int id;
	private String title;
	private String details;
	private Date deadline;
	private String priority;
	
	public Task(){
		
	}
	public Task(String title, String details, Date deadline,
			String priority) {
		this.title = title;
		this.details = details;
		this.deadline = deadline;
		this.priority = priority;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getPriority() {
		return priority;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getDeadline() {
		return deadline;
	}
	
}
