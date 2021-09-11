package com.j6.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j6.entity.Roles;

public interface RoleDAO extends JpaRepository<Roles, String>{

}
