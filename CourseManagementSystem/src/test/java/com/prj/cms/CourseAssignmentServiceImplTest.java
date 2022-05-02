package com.prj.cms;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prj.cms.entity.CourseAssignments;
import com.prj.cms.repository.CourseAssignemtsRepository;
import com.prj.cms.service.impl.CourseAssignmentServiceImpl;

@ExtendWith(MockitoExtension.class)
class CourseAssignmentServiceImplTest {
	@InjectMocks
	CourseAssignmentServiceImpl service;
	@Mock
	CourseAssignemtsRepository repository;

	CourseAssignments cassignment = new CourseAssignments();

	@Test
	void saveAssignmentTest() {
		when(repository.save(cassignment)).thenReturn(cassignment);
		service.saveCourseAssignment(cassignment);
		verify(repository, atLeastOnce()).save(cassignment);
	}

}
