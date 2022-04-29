package com.prj.cms.service;

import java.util.List;

import com.prj.cms.entity.Assignment;

public interface AssignmentService {

	List<Assignment> getAllAssignments();

	Assignment saveAssignment(Assignment assignment);

	Assignment updateAssignment(Assignment assignment);

	Assignment getAssignmentById(int id);

}
