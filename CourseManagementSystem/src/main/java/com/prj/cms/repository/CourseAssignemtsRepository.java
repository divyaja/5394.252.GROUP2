package com.prj.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prj.cms.entity.CourseAssignments;

@Repository
public interface CourseAssignemtsRepository extends JpaRepository<CourseAssignments, Integer>{

}
