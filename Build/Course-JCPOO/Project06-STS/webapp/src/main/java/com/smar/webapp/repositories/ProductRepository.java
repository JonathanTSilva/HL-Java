package com.smar.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smar.webapp.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
