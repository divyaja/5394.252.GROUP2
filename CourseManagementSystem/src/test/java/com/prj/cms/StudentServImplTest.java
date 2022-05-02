package com.prj.cms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prj.cms.entity.Course;
import com.prj.cms.repository.CourseRepository;
import com.prj.cms.service.impl.StudentServiceImpl;

@ExtendWith(MockitoExtension.class)
class StudentServImplTest {

	@InjectMocks
	StudentServiceImpl service;

	@Mock
	private CourseRepository repository;
	List<Course> list = new ArrayList<Course>();
	Course course = new Course();

	@Test
	void saveCourseTest() {
		when(repository.save(course)).thenReturn(course);
		service.saveCourse(course);
		verify(repository, atLeastOnce()).save(course);
	}
	
	@Test
	void getAllCoursesTest() {
		when(repository.findAll()).thenReturn(list);
		assertEquals(service.getAllCourses(),list);
	}

}
