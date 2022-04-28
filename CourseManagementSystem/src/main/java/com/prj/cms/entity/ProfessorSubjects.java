package com.prj.cms.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorSubjects implements Serializable {

	private int courseId;
	private Long professorId;

	public ProfessorSubjects() {
	}

}
