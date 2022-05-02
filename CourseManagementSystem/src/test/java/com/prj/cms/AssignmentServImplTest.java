package com.prj.cms;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

	Assignment assignment = new Assignment();

	@Test
	void saveAssignmentTest() {
		when(repository.save(assignment)).thenReturn(assignment);
		service.saveAssignment(assignment);
		verify(repository, atLeastOnce()).save(assignment);
	}

}
