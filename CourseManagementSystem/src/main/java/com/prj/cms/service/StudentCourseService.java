package com.prj.cms.service;

import java.util.List;

import com.prj.cms.entity.StudentCourses;

public interface StudentCourseService {
	StudentCourses saveStudentCourse(StudentCourses studentCourse);

	List<StudentCourses> findAllCourseStudentMappings();

	void deleteStudentCourse(StudentCourses studentCourseMapping);
}
