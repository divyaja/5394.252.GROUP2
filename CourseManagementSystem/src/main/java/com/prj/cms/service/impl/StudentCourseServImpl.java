package com.prj.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cms.entity.StudentCourses;
import com.prj.cms.repository.StudentCoursesRepository;
import com.prj.cms.service.StudentCourseService;

@Service
public class StudentCourseServImpl implements StudentCourseService {

	@Autowired
	private StudentCoursesRepository studentCourseRepository;

	public StudentCourseServImpl(StudentCoursesRepository studentCourseRepository) {
		super();
		this.studentCourseRepository = studentCourseRepository;
	}

	@Override
	public StudentCourses saveStudentCourse(StudentCourses studentCourse) {
		return studentCourseRepository.save(studentCourse);
	}

	@Override
	public List<StudentCourses> findAllCourseStudentMappings() {
		return studentCourseRepository.findAll();
	}

	@Override
	public void deleteStudentCourse(StudentCourses studentCourseMapping) {
		studentCourseRepository.delete(studentCourseMapping);
	}

}
