package com.prj.cas.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Timestamp dueDate;
	private Timestamp uploadedData;
	private int marks;
	private Long courseId;
	@Column(unique = true)
	private String fileName;

	public Assignment(Timestamp dueDate, Timestamp uploadedData, int marks, Long courseId, String fileName) {
		super();
		this.dueDate = dueDate;
		this.uploadedData = uploadedData;
		this.marks = marks;
		this.courseId = courseId;
		this.fileName = fileName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public Timestamp getUploadedData() {
		return uploadedData;
	}

	public void setUploadedData(Timestamp uploadedData) {
		this.uploadedData = uploadedData;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Assignment [id=" + id + ", dueDate=" + dueDate + ", uploadedData=" + uploadedData + ", marks=" + marks
				+ ", courseId=" + courseId + ", fileName=" + fileName + "]";
	}

}
