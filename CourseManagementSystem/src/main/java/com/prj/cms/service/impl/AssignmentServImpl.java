package com.prj.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cms.entity.Assignment;
import com.prj.cms.repository.AssignmentRespository;
import com.prj.cms.service.AssignmentService;

@Service
public class AssignmentServImpl implements AssignmentService {

	@Autowired
	private AssignmentRespository repository;

	@Override
	public List<Assignment> getAllAssignments() {
		return repository.findAll();
	}

	@Override
	public Assignment saveAssignment(Assignment assignment) {
		return repository.save(assignment);
	}

	@Override
	public Assignment updateAssignment(Assignment assignment) {
		return repository.save(assignment);
	}

	@Override
	public Assignment getAssignmentById(int id) {
		return repository.getById(id);
	}

}
