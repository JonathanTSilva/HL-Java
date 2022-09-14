package com.smar.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smar.webapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
