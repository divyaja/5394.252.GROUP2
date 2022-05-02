package com.prj.cms;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prj.cms.entity.ProfessorCourses;
import com.prj.cms.repository.ProfessorCourseRespository;
import com.prj.cms.service.impl.ProfessorCourseImpl;

@ExtendWith(MockitoExtension.class)
class ProfessorCourseImplTest {

	@InjectMocks
	ProfessorCourseImpl service;
	@Mock
	ProfessorCourseRespository repository;

	ProfessorCourses course = new ProfessorCourses();

	@Test
	void saveCourseTest() {
		when(repository.save(course)).thenReturn(course);
		service.saveProfessorCourse(course);
		verify(repository, atLeastOnce()).save(course);
	}

	@Test
	void deleteCourseMappingTest() {
		doNothing().when(repository).delete(course);
		service.deleteProfessorCourseMapping(course);
		verify(repository, atLeastOnce()).delete(course);
	}
}
