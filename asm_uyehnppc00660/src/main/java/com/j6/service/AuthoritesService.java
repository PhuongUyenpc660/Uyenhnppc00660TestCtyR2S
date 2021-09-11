package com.j6.service;

import java.util.List;

import com.j6.entity.Authorities;

public interface AuthoritesService {

	List<Authorities> findAll();

	Authorities save(Authorities authorities);

	void delete(Integer id);

	List<Authorities> getAuthoritiesOfAdministators();

}
