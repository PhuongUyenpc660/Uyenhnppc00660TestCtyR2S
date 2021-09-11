package com.j6.service;

import java.util.List;

import com.j6.entity.Accounts;
import com.j6.entity.Product;

public interface AccountsService {
	Accounts findById(String id);

	List<Accounts> findAll();

	List<Accounts> getAdministrators();
	Accounts findById(Integer id);

	Accounts create(Accounts account);

	Accounts update(Accounts account);

	void deleteById(String id);


	
}
