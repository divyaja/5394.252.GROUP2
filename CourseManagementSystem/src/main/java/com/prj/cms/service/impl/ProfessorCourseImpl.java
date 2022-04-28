package com.prj.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cms.entity.ProfessorCourses;
import com.prj.cms.repository.ProfessorCourseRespository;
import com.prj.cms.service.ProfessorServive;

@Service
public class ProfessorCourseImpl implements ProfessorServive {

	@Autowired
	private ProfessorCourseRespository professorCourseRespository;
	

	@Override
	public ProfessorCourses saveProfessorCourse(ProfessorCourses professorCourse) {
		return professorCourseRespository.save(professorCourse);
	}

	@Override
	public List<ProfessorCourses> findAllCourseProfessorMappings() {
		return professorCourseRespository.findAll();
	}

}
