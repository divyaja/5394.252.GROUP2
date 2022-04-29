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

	// private List<Assignment> assignments;

	/*
	 * @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "student_courses", joinColumns = @JoinColumn(name =
	 * "course_id", referencedColumnName = "id"), inverseJoinColumns
	 * = @JoinColumn(name = "student_id", referencedColumnName = "id")) private
	 * Collection<User> students;
	 */
	// private List<Assignment> assignments;

	public Course(int id, String courseName) {
		super();
		this.id = id;
		this.courseName = courseName;
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
