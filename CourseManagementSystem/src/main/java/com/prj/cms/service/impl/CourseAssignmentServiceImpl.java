package com.prj.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cms.entity.CourseAssignments;
import com.prj.cms.repository.CourseAssignemtsRepository;
import com.prj.cms.service.CourseAssignmentService;

@Service
public class CourseAssignmentServiceImpl implements CourseAssignmentService {

	@Autowired
	private CourseAssignemtsRepository repository;

	@Override
	public List<CourseAssignments> getAllAssignments() {
		return repository.findAll();
	}

	@Override
	public void deleteCourseAssignment(CourseAssignments courseAssignment) {
		repository.delete(courseAssignment);
	}

	@Override
	public CourseAssignments saveCourseAssignment(CourseAssignments courseAssignment) {
		return repository.save(courseAssignment);
	}

}
