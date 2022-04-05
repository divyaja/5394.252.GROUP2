package com.prj.cas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grades {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long personId;
	private Long courseId;
	private float grade;
	private Long assignmentId;

	public Grades(Long personId, Long courseId, float grade, Long assignmentId) {
		super();
		this.personId = personId;
		this.courseId = courseId;
		this.grade = grade;
		this.assignmentId = assignmentId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	@Override
	public String toString() {
		return "Grades [personId=" + personId + ", courseId=" + courseId + ", grade=" + grade + ", assignmentId="
				+ assignmentId + "]";
	}

}
