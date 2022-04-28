package com.prj.cms.service;

import java.util.List;

import com.prj.cms.entity.Course;

public interface StudentService {

	List<Course> getAllCourses();

	Course findByName(String courseName);

	Course saveCourse(Course course);

}
