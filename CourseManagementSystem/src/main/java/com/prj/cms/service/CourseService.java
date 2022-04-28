package com.prj.cms.service;

import java.util.List;

import com.prj.cms.entity.Course;

public interface CourseService {
	List<Course> getAllCourses();

	Course saveCourse(Course course);

	Course updateCourse(Course course);

	Course getCourseById(int id);

	void deleteCourseById(int id);

	Course findByName(String courseName);

}
