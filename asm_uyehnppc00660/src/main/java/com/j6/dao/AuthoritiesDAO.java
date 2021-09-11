package com.j6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.j6.entity.Accounts;
import com.j6.entity.Authorities;

public interface AuthoritiesDAO extends JpaRepository<Authorities, Integer> {
	@Query("SELECT DISTINCT a FROM Authorities a WHERE a.account IN ?1")
	List<Authorities> authoritiesOf(List<Accounts> accounts);

}
