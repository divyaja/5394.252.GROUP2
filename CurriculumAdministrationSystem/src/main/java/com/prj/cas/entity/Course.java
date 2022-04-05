package com.prj.cas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String courseName;
	private boolean isCourseActive;
	private int branchId;
	private String courseId;

	public Course() {

	}

	public Course(String courseName, boolean isCourseActive, int branchId, String courseId) {
		super();
		this.courseName = courseName;
		this.isCourseActive = isCourseActive;
		this.branchId = branchId;
		this.courseId = courseId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public boolean isCourseActive() {
		return isCourseActive;
	}

	public void setCourseActive(boolean isCourseActive) {
		this.isCourseActive = isCourseActive;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", isCourseActive=" + isCourseActive + ", branchId="
				+ branchId + ", courseId=" + courseId + "]";
	}

}
