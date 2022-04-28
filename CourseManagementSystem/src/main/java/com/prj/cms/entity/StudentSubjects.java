package com.prj.cms.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentSubjects implements Serializable{

	private int courseId;
	private Long studentId;
	
	public StudentSubjects() {}
	
}
