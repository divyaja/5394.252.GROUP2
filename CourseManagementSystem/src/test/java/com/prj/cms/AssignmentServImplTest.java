package com.prj.cms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prj.cms.entity.Assignment;
import com.prj.cms.repository.AssignmentRespository;
import com.prj.cms.service.impl.AssignmentServImpl;

@ExtendWith(MockitoExtension.class)
class AssignmentServImplTest {
	@InjectMocks
	AssignmentServImpl service;
	@Mock
	AssignmentRespository repository;

	List<Assignment> list = new ArrayList<Assignment>();

	Assignment assignment = new Assignment(1, 2, "bst tree", "adasdasd", "02/20/2022");

	@Test
	void saveAssignmentTest() {
		when(repository.save(assignment)).thenReturn(assignment);
		service.saveAssignment(assignment);
		verify(repository, atLeastOnce()).save(assignment);
	}

	@Test
	void updateAssignmentTest() {
		when(repository.save(assignment)).thenReturn(assignment);
		service.updateAssignment(assignment);
		verify(repository, atLeastOnce()).save(assignment);
	}

	@Test
	void getAssignmentByIdTest() {
		when(repository.getById(assignment.getId())).thenReturn(assignment);
		service.getAssignmentById(assignment.getId());
		verify(repository, atLeastOnce()).getById(assignment.getId());
	}
	@Test
	void getAllAssignmentsTest() {
		when(repository.findAll()).thenReturn(list);
		assertEquals(service.getAllAssignments(),list);
	}

	@Test
	void deleteAssignmentTest() {
		doNothing().when(repository).deleteById(assignment.getId());
		service.deleteAssignmentById(assignment.getId());
		verify(repository, atLeastOnce()).deleteById(assignment.getId());
	}

}
