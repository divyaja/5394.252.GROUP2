package com.prj.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "courses", uniqueConstraints = @UniqueConstraint(columnNames = "course_name"))
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + "]";
	}

	@Column(name = "course_name", nullable = false)
	private String courseName;

	@Column(name = "student_id")
	private int studentID;
	
	@Column(name = "student_emailId")
	private int studentEmailID;

	// private List<Assignment> assignments;

	public int getStudentEmailID() {
		return studentEmailID;
	}

	public void setStudentEmailID(int studentEmailID) {
		this.studentEmailID = studentEmailID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public Course() {

	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
