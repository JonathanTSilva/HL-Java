package com.smar.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smar.webapp.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
