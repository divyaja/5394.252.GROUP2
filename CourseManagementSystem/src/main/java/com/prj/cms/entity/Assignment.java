package com.prj.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "assignment", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "assignment_name", nullable = false)
	private String assignmentName;
	@Column(name = "due_date")
	private String dueDate;

	public Assignment(int id, String assignmentName, String date) {
		this.id = id;
		this.assignmentName = assignmentName;
		this.dueDate = date;
	}

}
