package com.prj.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IdClass(CourseAssignmentData.class)
@Entity(name = "course_assignments")
public class CourseAssignments {

	@Id
	@Column(name = "course_id", nullable = false)
	private int courseId;
	@Id
	@Column(name = "assignment_id", nullable = false)
	private Long assignmentId;

	public CourseAssignments(int courseId, Long assignmentId) {
		super();
		this.courseId = courseId;
		this.assignmentId = assignmentId;
	}

	@Override
	public String toString() {
		return "CourseAssignments [courseId=" + courseId + ", assignmentId=" + assignmentId + "]";
	}

}
