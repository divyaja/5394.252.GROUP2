package com.prj.cms.entity;

public class Submission {
	
	private int id;
	private String studentName;
	private String answer;
	private String date;
	
	public Submission(int id, String studentName, String answer, String date) {
		
		this.id = id;
		this.studentName = studentName;
		this.answer = answer;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
