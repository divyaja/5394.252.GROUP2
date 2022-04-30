package com.prj.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.prj.cms.entity.ProfessorCourses;

@Repository
public interface ProfessorCourseRespository extends JpaRepository<ProfessorCourses, Integer> {

}
