package com.smar.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smar.webapp.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
