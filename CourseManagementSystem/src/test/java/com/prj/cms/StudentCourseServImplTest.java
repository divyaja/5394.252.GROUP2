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

import com.prj.cms.entity.StudentCourses;
import com.prj.cms.repository.StudentCoursesRepository;
import com.prj.cms.service.impl.StudentCourseServImpl;

@ExtendWith(MockitoExtension.class)
class StudentCourseServImplTest {

	@InjectMocks
	StudentCourseServImpl service;

	List<StudentCourses> list = new ArrayList<StudentCourses>();

	@Mock
	private StudentCoursesRepository repository;

	StudentCourses course = new StudentCourses();

	@Test
	void saveStudentCourseTest() {
		when(repository.save(course)).thenReturn(course);
		service.saveStudentCourse(course);
		verify(repository, atLeastOnce()).save(course);
	}
	
	
	@Test
	void findAllCourseStudentMappingsTest() {
		when(repository.findAll()).thenReturn(list);
		assertEquals(service.findAllCourseStudentMappings(),list);
	}
	
	@Test
	void deleteStudentCourseMappingTest() {
		doNothing().when(repository).delete(course);
		service.deleteStudentCourse(course);
		verify(repository, atLeastOnce()).delete(course);
	}

	
}
