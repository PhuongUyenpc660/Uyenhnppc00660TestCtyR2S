package com.j6.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j6.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {

}
