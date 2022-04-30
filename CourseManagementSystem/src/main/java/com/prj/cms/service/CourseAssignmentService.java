package com.prj.cms.service;

import java.util.List;

import com.prj.cms.entity.CourseAssignments;

public interface CourseAssignmentService {

	List<CourseAssignments> getAllAssignments();
	
	CourseAssignments saveCourseAssignment(CourseAssignments courseAssignment);
	
	void deleteCourseAssignment(CourseAssignments courseAssignment);

}
