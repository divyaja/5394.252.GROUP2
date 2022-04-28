package com.prj.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(StudentSubjects.class)
@Table(name = "student_courses")
public class StudentCourses {

	@Id
	@Column(name = "course_id", nullable = false)
	private int courseId;
	@Id
	@Column(name = "student_id", nullable = false)
	private Long studentId;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public StudentCourses() {

	}

	public StudentCourses(int courseId, Long studentId) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "StudentCourses [courseId=" + courseId + ", studentId=" + studentId + "]";
	}

}
