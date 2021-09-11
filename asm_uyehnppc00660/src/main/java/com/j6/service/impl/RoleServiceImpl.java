package com.j6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.RoleDAO;
import com.j6.entity.Roles;
import com.j6.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDAO dao;
	
	@Override
	public List<Roles> findAll() {
		return dao.findAll();
	}

}
