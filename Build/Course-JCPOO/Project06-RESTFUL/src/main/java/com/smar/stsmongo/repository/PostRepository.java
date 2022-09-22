package com.smar.stsmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.smar.stsmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Consulta simples com @Query
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);
    
    // Consulta simples com query methods
    List<Post> findByTitleContainingIgnoreCase(String text);
    
}