package com.prj.cms.service;

import java.util.List;

import com.prj.cms.entity.ProfessorCourses;

public interface ProfessorServive {

	ProfessorCourses saveProfessorCourse(ProfessorCourses proCourse);

	List<ProfessorCourses> findAllCourseProfessorMappings();

}
