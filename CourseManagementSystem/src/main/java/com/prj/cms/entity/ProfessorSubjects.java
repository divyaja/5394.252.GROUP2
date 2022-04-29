package com.prj.cms.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorSubjects implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6490603657778401517L;
	private int courseId;
	private Long professorId;

	public ProfessorSubjects() {
	}

}
