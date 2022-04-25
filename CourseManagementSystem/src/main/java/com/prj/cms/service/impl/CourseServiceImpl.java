package com.prj.cms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prj.cms.entity.Course;
import com.prj.cms.repository.CourseRepository;
import com.prj.cms.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course getCourseById(int id) {
		return courseRepository.findById(id).get();
	}

	@Override
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourseById(int id) {
		courseRepository.deleteById(id);

	}

	@Override
	public Course findByName(String courseName) {
		return courseRepository.findByCourseName(courseName);
	}

}
