package com.smar.stsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smar.stsmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}