package com.smar.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smar.webapp.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
