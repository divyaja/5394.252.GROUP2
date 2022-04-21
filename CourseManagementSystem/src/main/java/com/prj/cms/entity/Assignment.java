package com.prj.cms.entity;

import java.util.List;

public class Assignment {
	
	private int id;
	private String assignmentName;
	private int numOfSubmissions;
	private String date;
	private List<Submission> submissions;
	
	public Assignment(int id, String assignmentName, int numOfSubmissions, String date, List<Submission> submissions) {
		
		this.id = id;
		this.assignmentName = assignmentName;
		this.numOfSubmissions = numOfSubmissions;
		this.date = date;
		this.submissions = submissions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public int getNumOfSubmissions() {
		return numOfSubmissions;
	}

	public void setNumOfSubmissions(int numOfSubmissions) {
		this.numOfSubmissions = numOfSubmissions;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}
}
