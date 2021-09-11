package com.j6.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.j6.entity.Accounts;

public interface AccountDAO extends JpaRepository<Accounts, String> {
	@Query("SELECT DISTINCT ar.account FROM Authorities ar WHERE ar.role.id IN ('DIRE', 'STAF')")
	List<Accounts> getAdministrators();

    
}
