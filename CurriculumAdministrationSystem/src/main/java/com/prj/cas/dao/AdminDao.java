package com.prj.cas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.cas.entity.User;

public interface AdminDao extends JpaRepository<User, Long>{

}
