package com.smar.stsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smar.stsmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}