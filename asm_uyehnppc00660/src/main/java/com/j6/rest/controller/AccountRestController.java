package com.j6.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.j6.entity.Accounts;
import com.j6.entity.Product;
import com.j6.service.AccountsService;

@CrossOrigin("*")	
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountsService service;
	
	@GetMapping
	public List<Accounts> getAccounts(){
		return service.findAll();
	}

	@GetMapping("{id}")
	public Accounts getOne(@PathVariable("id") String id) {
		return service.findById(id);
	}


	@PostMapping()
	public Accounts save(@RequestBody Accounts account) {
		return service.create(account);
	}

	@PutMapping("{id}")
	public Accounts put(@PathVariable("id") String id, @RequestBody Accounts account) {
		return service.update(account);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		service.deleteById(id);
	}

}
