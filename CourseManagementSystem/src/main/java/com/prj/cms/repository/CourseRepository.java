package com.prj.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prj.cms.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	Course findByCourseName(String courseName);

}
