package com.j6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.AccountDAO;
import com.j6.dao.AuthoritiesDAO;
import com.j6.entity.Accounts;
import com.j6.entity.Authorities;
import com.j6.service.AuthoritesService;

@Service
public class AuthoritiesServiceImpl implements AuthoritesService {
	@Autowired
	AccountDAO AccountDAO;
	@Autowired
	AuthoritiesDAO dao;


	@Override
	public List<Authorities> findAll() {
		return dao.findAll();
	}

	@Override
	public Authorities save(Authorities authorities) {
		return dao.save(authorities);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);

	}

	@Override
	public List<Authorities> getAuthoritiesOfAdministators() {
		List<Accounts> accounts = AccountDAO.getAdministrators();
		return dao.authoritiesOf(accounts);
	}

}
