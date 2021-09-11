package com.j6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.AccountDAO;
import com.j6.entity.Accounts;
import com.j6.service.AccountsService;

@Service
public class AccountServiceImpl implements AccountsService {
	@Autowired
	AccountDAO dao;

	@Override
	public Accounts findById(String id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Accounts> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Accounts> getAdministrators() {
		return dao.getAdministrators();
	}


	@Override
	public Accounts create(Accounts account) {
		return dao.save(account);
	}

	@Override
	public Accounts update(Accounts account) {
		return dao.save(account);
	}


	@Override
	public void deleteById(String id) {
		dao.deleteById(id);		
	}

	@Override
	public Accounts findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void deleteById(Integer id) {
//		// TODO Auto-generated method stub
//		
//	}


}
