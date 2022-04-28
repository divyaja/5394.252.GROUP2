package com.prj.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(ProfessorSubjects.class)
@Table(name = "professor_courses")
public class ProfessorCourses {

	@Id
	@Column(name = "course_id", nullable = false)
	private int courseId;
	@Id
	@Column(name = "professor_id", nullable = false)
	private Long professorId;

	public ProfessorCourses(int courseId, Long professorId) {
		super();
		this.courseId = courseId;
		this.professorId = professorId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	@Override
	public String toString() {
		return "ProfessorCourses [courseId=" + courseId + ", professorId=" + professorId + "]";
	}

	public ProfessorCourses() {
	}

}
