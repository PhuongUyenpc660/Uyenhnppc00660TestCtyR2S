package com.j6.service;

import java.util.List;

import com.j6.entity.Product;

public interface ProductService  {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String id);

	Product create(Product product);

	Product update(Product product);

	void deleteById(Integer id);

}
