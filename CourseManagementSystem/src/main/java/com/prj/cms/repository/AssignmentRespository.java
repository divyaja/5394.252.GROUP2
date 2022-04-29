package com.prj.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prj.cms.entity.Assignment;

@Repository
public interface AssignmentRespository extends JpaRepository<Assignment, Integer> {

}
