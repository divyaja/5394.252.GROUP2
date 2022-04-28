package com.prj.cms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prj.cms.entity.Course;
import com.prj.cms.repository.CourseRepository;
import com.prj.cms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private CourseRepository courseRepository;

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course findByName(String courseName) {
		return courseRepository.findByCourseName(courseName);
	}

}